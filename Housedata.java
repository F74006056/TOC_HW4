
public class Housedata {
	public int check(int com,String in)
	{
		switch(com)
		{
		case 33554432:
			if(in.equals("�m����"))
				return 4;
		break;
		case 16777216:
			if(in.equals("����Ъ�"))
				return 5;
		break;
		case 8388608:
			if(in.equals("�g�a�Ϭq��m�Ϋت��Ϫ��P"))
				return 6;
		break;
		case 4194304:
			if(in.equals("�g�a�����`���n���褽��"))
				return 7;
		break;
		case 2097152:
			if(in.equals("�����g�a�ϥΤ���"))
				return 8;
		break;
		case 1048576:
			if(in.equals("�D�����g�a�ϥΤ���"))
				return 9;
		break;
		case 524288:
			if(in.equals("�D�����g�a�ϥνs�w"))
				return 10;
		break;
		case 262144:
			if(in.equals("����~��"))
				return 11;
		break;
		case 131072:
			if(in.equals("������ɼ�"))
				return 12;
		break;
		case 65536:
			if(in.equals("����h��"))
				return 13;
		break;
		case 32768:
			if(in.equals("�`�Ӽh��"))
				return 14;
		break;
		case 16384:
			if(in.equals("�ت����A"))
				return 15;
		break;
		case 8172:
			if(in.equals("�D�n�γ~"))
				return 16;
		break;
		case 4096:
			if(in.equals("�D�n�ا�"))
				return 17;
		break;
		case 2048:
			if(in.equals("�ؿv�����~��"))
				return 18;
		break;
		case 1024:
			if(in.equals("�ت������`���n���褽��"))
				return 19;
		break;
		case 512:
			if(in.equals("�ت��{�p�槽-��"))
				return 20;
		break;
		case 256:
			if(in.equals("�ت��{�p�槽-�U"))
				return 21;
		break;
		case 128:
			if(in.equals("�ت��{�p�槽-��"))
				return 22;
		break;
		case 64:
			if(in.equals("�ت��{�p�槽-�j��"))
				return 23;
		break;
		case 32:
			if(in.equals("���L�޲z��´"))
				return 24;
		break;
		case 16:
			if(in.equals("�`����"))
				return 25;
		break;
		case 8:
			if(in.equals("����C���褽��"))
				return 26;
		break;
		case 4:
			if(in.equals("�������O"))
				return 27;
		break;
		case 2:
			if(in.equals("���첾���`���n���褽��"))
				return 28;
		break;
		case 1:
			if(in.equals("�����`����"))
				return 29;
		break;
		}
		System.out.println(in);
		return -1;
	}
	public String locate;//�m����
	public String usage;//����Ъ�
	public String road;//�g�a�Ϭq��m�Ϋت��Ϫ��P
	public float area;//�g�a�����`���n���褽��
	public String cityuse;//�����g�a�ϥΤ���
	public String nocityuse;//�D�����g�a�ϥΤ���
	public String nocityschedule;//�D�����g�a�ϥνs�w
	public int tradedate;//����~��
	public String soldnum;//������ɼ�
	public String tradefloor;//����h��
	public String totalfloor;//�`�Ӽh��
	public String buildtype;//�ت����A
	public String mainusage;//�D�n�γ~
	public String material;//�D�n�ا�
	public int builddate;//�ؿv�����~��
	public int tradearea;//�ت������`���n���褽��
	public int room;//�ت��{�p�槽-��
	public int hall;//�ت��{�p�槽-�U
	public int methodist;//�ت��{�p�槽-��
	public String divide;//�ت��{�p�槽-�j��
	public String manager;//���L�޲z��´
	public int price;//�`����
	public float priceperarea;//����C���褽��
	public String cartype;//�������O
	public float cararea;//���첾���`���n���褽��
	public int carprice;//�����`����
}
