import java.util.*;

public class Main
{
	public static int search(int k, int i, String b[], String a[][])
	{
		int j=0,col3=0;
		while(j < a[i].length)
		{
			if(a[i][j].equals(b[k]))
			{
				col3=j;
				break;
			}
			j++;
		}
		return col3 ;
	}
	public static int route(int col1, int col3, int row1, int count, String a[][])
	{
		if(col1 < col3)
		{       col1++;
			while(col1!=col3)
			{
				System.out.println(count+". "+a[row1][col1] + "\t");
				col1++;
				count++;
			}

		}
		else if(col1>col3)
		{       col1--;
			while(col1!=col3)
			{
				System.out.println(count+". "+a[row1][col1] + "\t");
				col1--;
				count++;
			}

		}
		return count;

	}

	public static void main(String[] args)
	{	
		//0violet
		//1yellow
		//2orange
		//3blue..dwarka to ncc
		//4blue..vaishali to yamuna bank
		//5green
		//6red
		String[][] a= new String[][]{  {"badarpur","tughlakabad","mohan estate","sarita vihar","jasola apollo","okhla","govind puri","kalkaji mandir","nehru place","kailash colony","moolchand","lajpat nagar","jangpura","jln stadium","khan market","central secretariate"},
				{"huda city centre","iffco chowk","mg road","sikanderpur","guru dronacharya","arjangarh","ghitorni","sultanpur","chhattarpur","qutab minar","saket","malviya nagar","hauz khas","green park","aiims","ina","jor bagh","race course","udyog bhawan","central secretariate","patel chowk","rajiv chowk","new delhi","chawri bazar","chandni chowk","kashmere gate","tis hazari","civil lines","vidhan sabha","vishwavidyalaya","gtb nagar","model town","azadpur","adarsh nagar","jahangir puri"},
			     	{"dwarka sector 21","igi_airport","delhi aero city","dhaula kuan","shivaji stadium","new delhi"},
				{"dwarka sector 21","dwarka sector 8","dwarka sector 9","dwarka sector 10","dwarka sector 11","dwarka sector 12","dwarka sector 13","dwarka sector 14","dwarka","dwarka more","nawada","uttam nagar west","uttam nagar east","janakpuri west","janakpuri east","tilak nagar","subhash nagar","tagore garden","rajouri garden","ramesh nagar","moti nagar","kirti nagar","shadipur","patel nagar","rajendra place","karol bagh","jhandewalan","ramakrishna ashram marg","rajiv chowk","barakhamba road","mandi house","pragati maidan","indraprastha","yamuna bank","akshardham","mayur vihar 1","mayur vihar extn.","new ashok nagar","noida sector 15","noida sector 16","noida sector 18","botanical garden","golf course","noida city centre"},
				{"vaishali","kaushambi","anand vihar isbt","karkardooma","preet vihar","nirman vihar","laxmi nagar","yamuna bank"},
				{"mundka","rajdhani park","nangloi railway station","nangloi","surajmal stadium","udyog nagar","peeragarhi","paschim vihar west","paschim vihar east","madipur","shivaji park","punjabi bagh","ashok park main","satguru ram singh marg","kirti nagar"},
				{"rithala","rohini west","rohini east","pitampura","kohat enclave","netaji subhash place","keshav puram","kanhaiya nagar","inderlok","shastri nagar","pratap nagar","pulbangash","tis hazari","kashmere gate","shastri park","seelampur","welcome","shahdara","mansarovar park","jhilmil","dilshad garden"}
			     };
		String[] b={"central secretariate","rajiv chowk","kashmere gate","dwarka sector 21","new delhi","kirti nagar","yamuna bank","ashok park main","inderlok"};
		System.out.println("Enter start & stop stations");
		Scanner s=new Scanner (System.in);
		String start,stop;
		start=s.nextLine();
		stop=s.nextLine();
		start = start.toLowerCase();
		stop = stop.toLowerCase();
		if(start.equals(stop))
		{
			System.out.println("Source And Destination Stations are the same\n");
 			System.exit(0);
		}
		int i=0,j,k=0,change=0,row1=0,count=1,row2=0,col1=0,col2=0,col3=0,k2=0,row3=0,k1=0,flag=0,flag1=0,flag2=0,flag3=0,row4=0,col4=0;
		for(i=0;i<7;i++)
		{
			j=0;
			while(j < a[i].length)
			{	
				if(a[i][j].equals(start))
				{
					flag=1;
					row1=i;
					col1=j;
				}
				if(a[i][j].equals(stop))
				{
					flag1=1;
					row2=i;
					col2=j;
				}
				j++;
			}
		}
					
		if(flag==0 || flag1==0)
		{	System.out.println("Stations does not exist");
			System.exit(0);
		}
		System.out.println("\n\n\n\nYour route is as follows: ");
		System.out.println(count+". "+"Start from "+start); 
		count++;
		
//main logic
  if(row1 == row2)
  {
	route(col1,col2,row1,count,a);
	System.out.println(count+". "+"Get off at "+a[row2][col2]);
 }
  else
  {
	//for yamuna bank
	if(row1==4&&col2<=33)
			flag2=1;
	if(row2==4&&col1<=33)
			flag3=1;

	if((row1==0&&row2==1) || (row1==1&&row2==0))
	{
		k=0;
		change=1;
	}
	else if((row1==3&&row2==4) || (row1==4&&row2==3))
	{
		k=6;
		change=1;
	}
	else if((row1==3&&row2==1) || (row1==1&&row2==3))
	{
		k=1;
		change=1;
	}
	else if((row1==3&&row2==2) || (row1==2&&row2==3))
	{	
		k=3;
		change=1;
	}
	else if((row1==3&&row2==5) || (row1==5&&row2==3))
	{	
		k=5;
		change=1;
	}
	else if((row1==1&&row2==6) || (row1==6&&row2==1))
	{
		k=2;
		change=1;
	}
//condition for 2 changes starts 
	//1
	else if(row1==0&&row2==2)
	{	
		k=0;
		k1=4;
		row3=1;
		change=2;
	}
	else if(row1==2&&row2==0)
	{
		k=4;		
		k1=0;
		row3=1;
		change=2;
	}
	//2
	else if(row1==0&&row2==3)
	{	
		k=0;
		k1=1;
		row3=1;
		change=2;
	}
	else if(row1==3&&row2==0)
	{
		k=1;		
		k1=0;
		row3=1;
		change=2;
	}
	//3
	else if(row1==0&&row2==6)
	{	
		k=0;
		k1=2;
		row3=1;
		change=2;
	}
	else if(row1==6&&row2==0)
	{
		k=2;		
		k1=0;
		row3=1;
		change=2;
	}
	//4
	else if(row1==1&&row2==4)
	{	
		k=1;
		k1=6;
		row3=3;
		change=2;
	}
	else if(row1==4&&row2==1)
	{
		k=6;		
		k1=1;
		row3=3;
		change=2;
	}
//******************************************************orange-to-blue..2 diff routes	//5
	else if(row1==2&&row2==3)
	{	
		k=4;
		k1=1;
		row3=1;
		change=2;
	}
	else if(row1==3&&row2==2)
	{
		k=1;		
		k1=4;
		row3=1;
		change=2;
	}
//***************
	//6
	else if(row1==2&&row2==6)
	{	
		k=4;
		k1=2;
		row3=1;
		change=2;
	}
	else if(row1==6&&row2==2)
	{
		k=2;		
		k1=4;
		row3=1;
		change=2;
	}
	//7
	else if(row1==3&&row2==6)
	{	
		k=1;
		k1=2;
		row3=1;
		change=2;
	}
	else if(row1==6&&row2==3)
	{
		k=2;		
		k1=1;
		row3=1;
		change=2;
	}
//condition fr 2 chnages ends
//condition fr 3 change starts
	//1
	else if(row1==0&&row2==4)
	{	
		k=0;
		k1=1;
		k2=6;
		row3=1;
		row4=3;
		change=3;
	}
	else if(row1==4&&row2==0)
	{
		k=6;		
		k1=1;
		k2=0;
		row3=3;
		row4=1;
		change=3;
	}
	//2
	else if(row1==2&&row2==4)
	{	
		k=4;
		k1=1;
		k2=6;
		row3=1;
		row4=3;
		change=3;
	}
	else if(row1==4&&row2==2)
	{
		k=6;		
		k1=1;
		k2=4;
		row3=3;
		row4=1;
		change=3;
	}
	//3
	else if(row1==4&&row2==6)
	{	
		k=6;
		k1=1;
		k2=2;
		row3=3;
		row4=1;
		change=3;
	}
	else if(row1==6&&row2==4)
	{
		k=2;		
		k1=1;
		k2=6;
		row3=1;
		row4=3;
		change=3;
	}
//condition fr 3 change ends
	if(change==1)
	{
		col3=search(k,row1,b,a);
		count=route(col1,col3,row1,count,a);
		if(flag2==0)
			System.out.println(count+". "+"Change at "+a[row1][col3]);
		else
			System.out.println(count+". "+a[row1][col3]);
		count++;
		col3=search(k,row2,b,a);
		count=route(col3,col2,row2,count,a);
		System.out.println(count+". "+"Get off at "+a[row2][col2]);
	}
	else if(change==2)
	{
		col3=search(k,row1,b,a);
		count=route(col1,col3,row1,count,a);
		if(flag2==0)
			System.out.println(count+". "+"Change at "+a[row1][col3]);
		else
			System.out.println(count+". "+a[row1][col3]);
		count++;
		col1=search(k,row3,b,a);
		col3=search(k1,row3,b,a);
		count=route(col1,col3,row3,count,a);
		if(flag3==0)
			System.out.println(count+". "+"Change at "+a[row3][col3]);
		else
			System.out.println(count+". "+a[row3][col3]);
		col3=search(k1,row2,b,a);
		count=route(col3,col2,row2,count,a);
		System.out.println(count+". "+"Get off at "+a[row2][col2]);
	}
	else if(change==3)
	{
		col3=search(k,row1,b,a);
		count=route(col1,col3,row1,count,a);
		if(flag2==0)
			System.out.println(count+". "+"Change at "+a[row1][col3]);
		else
			System.out.println(count+". "+a[row1][col3]);
		count++;
		col1=search(k,row3,b,a);
		col3=search(k1,row3,b,a);
		count=route(col1,col3,row3,count,a);
		System.out.println(count+". "+"Change at "+a[row3][col3]);
		count++;
		col1=search(k1,row4,b,a);
		col3=search(k2,row4,b,a);
		count=route(col1,col3,row4,count,a);
		if(flag3==0)
			System.out.println(count+". "+"Change at "+a[row4][col3]);
		else
			System.out.println(count+". "+a[row4][col3]);
		count++;
		col3=search(k2,row2,b,a);
		count=route(col3,col2,row2,count,a);
		System.out.println(count+". "+"Get off at "+a[row2][col2]);
	}
	

		
  }

		 

}
}
