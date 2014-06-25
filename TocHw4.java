/*
 * F74006056 劉弘偉
 * 將網站資料一個一個字抓下來做DFA
 * 並用skip&&compare去跳過不需要擷取的資料
 * 每讀完一個object符合就存入vector
 * 做雙重for迴圈跟if(contains)抓出所有每條路的有多少不同月 並統計最高最低價格
 * 最後output最多不同月的資訊
 */
import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class TocHw4 {

	public static void main(String[] args) 
	{
		URL url;
		char tempchar;
		int state=1;
		int skip=8650768;//00100001000000000000010000
		int compare=33554432;
		int ts=skip;
		int tc=compare;
		int excep;
		Vector<Housedata> store=new Vector<Housedata>();
		Housedata tempHd=new Housedata();
		try
		{
			url=new URL(args[0]);
			URLConnection conn = url.openConnection();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
			while(!br.ready());
			while(state!=33)
			{
				tempchar=(char)br.read();
				while(tempchar=='\n')tempchar=(char)br.read();
				switch(state)
				{
				case 1:
					if(tempchar=='[')
						state=2;
					else
						throw new Exception("parsing error1");
					break;
				case 2:
					if(tempchar=='{')
					{
						ts=skip;
						tc=compare;
						state=3;
					}
					else
						throw new Exception("parsing error2");
					break;
				case 3:
					if(tempchar=='"')
					{
						String t=new String();
						while((tempchar=(char)br.read())!='"')
							t+=tempchar;
						if((ts&tc)!=0)
						{
							if((state=tempHd.check(tc,t))==-1)
							{
								throw new Exception("variable name error");
							}
						}
						else
							state=30;
						while(tempchar!=':')tempchar=(char)br.read();
					}
					else
						throw new Exception("parsing error3");
					tc=tc>>1;
					break;
				//case 4:
				//case 5:
				case 6:
					if(tempchar=='"')
					{
						String t=new String();
						do
						{
							tempchar=(char)br.read();
							t+=tempchar;
						}while(tempchar!='路'&&tempchar!='街'&&tempchar!='"');
						if(tempchar=='"')
						{
							if(t.contains("大道"))
							{
								t=t.substring(0,t.indexOf("大道")+2);
							}
							else if(t.contains("巷"))
							{
								t=t.substring(0,t.indexOf("巷")+1);
							}
							else
							{
								state=34;
								continue;
							}
						}
						tempHd.road=t;
						while(tempchar!='"')
						{
							tempchar=(char)br.read();
						}
						//System.out.println(t);
						state=31;
					}
					else
						throw new Exception("parsing error6");
					break;
				//case 7:
				//case 8:
				//case 9:
				//case 10:
				case 11:
					if(tempchar<='9'&&tempchar>='0')
					{
						int t=0;
						do
						{
							t*=10;
							t+=tempchar-'0';
							tempchar=(char)br.read();
						}
						while(tempchar!=','&&tempchar!='}');
						tempHd.tradedate=t;
						if(tempchar==',')
							state=3;
						else
							state=32;
					}
					else
						throw new Exception("parsing error11");
					break;
				//case 12:
				//case 13:
				//case 14:
				//case 15:
				//case 16:
				//case 17:
				//case 18:
				//case 19:
				//case 20:
				//case 21:
				//case 22:
				//case 23:
				//case 24:
				case 25:
					if(tempchar<='9'&&tempchar>='0')
					{
						int t=0;
						do{
							t*=10;
							t+=tempchar-'0';
							tempchar=(char)br.read();
						}
						while(tempchar!=','&&tempchar!='}');
						tempHd.price=t;
						if(tempchar==',')
							state=3;
						else
							state=32;
					}
					else
						throw new Exception("parsing error25");
					break;
				//case 26:
				//case 27:
				//case 28:
				//case 29:
				case 30:
					while(tempchar!=','&&tempchar!='}')tempchar=(char)br.read();
					if(tempchar==',')
						state=3;
					else
						state=32;
					break;
				case 31:
					if(tempchar==',')
					{
						state=3;
					}
					else
						throw new Exception("parsing error31");
					break;
				case 32:
					if(tempchar==',')
					{
						state=2;
						if(ts!=0)
						{
							store.add(tempHd);
							//System.out.printf("%s,%d,%d\n",tempHd.road,tempHd.tradedate,tempHd.price);
							tempHd=new Housedata();
						}
					}
					else if(tempchar==']')
					{
						state=33;
					}
					else
						throw new Exception("parsing error32");
					break;
				case 33:
					break;
				case 34:
					excep=1;
					ts=0;
					while(excep!=0)
					{
						tempchar=(char)br.read();
						if(tempchar=='{')
							excep++;
						else if(tempchar=='}')
							excep--;
					}
					state=32;
					break;
				}
				while(!br.ready());
			}
			Vector<Integer> tempdm;
			int tmax;
			int tmin;
			int dmmax=0;
			Vector<String> S=new Vector<String>();
			Vector<Integer> dm=new Vector<Integer>();
			Vector<Integer> max=new Vector<Integer>();
			Vector<Integer> min=new Vector<Integer>();
			for(int i=0;i<store.size();++i)
			{
				if(!S.contains(store.elementAt(i).road))
					S.add(store.elementAt(i).road);
			}
			for(int i2=0;i2<S.size();++i2)
			{
				tempdm=new Vector<Integer>();
				tmax=0;
				tmin=Integer.MAX_VALUE;
				for(int i=0;i<store.size();++i)
				{
					if(store.elementAt(i).road.equals(S.elementAt(i2)))
					{
						if(!tempdm.contains(store.elementAt(i).tradedate))
							tempdm.add(store.elementAt(i).tradedate);
						if(store.elementAt(i).price>tmax)
							tmax=store.elementAt(i).price;
						if(store.elementAt(i).price<tmin)
							tmin=store.elementAt(i).price;
					}
				}
				if(tempdm.size()>dmmax)
					dmmax=tempdm.size();
				dm.add(tempdm.size());
				max.add(tmax);
				min.add(tmin);
			}
			for(int i2=0;i2<S.size();++i2)
			{
				if(dm.elementAt(i2)==dmmax)
				{
					System.out.printf("%s, 最高成交價: %d, 最低成交價: %d\n",S.elementAt(i2),max.elementAt(i2),min.elementAt(i2));
				}
			}

			br.close();
		}
		catch(MalformedURLException e)
		{
			System.out.println("open url fail");
		}
		catch (IOException e) 
		{}
		catch (Exception e) 
		{
			System.out.println(e.toString());
		}
	}
}
