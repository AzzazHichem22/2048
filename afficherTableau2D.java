import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class afficherTableau2D extends JFrame implements KeyListener {
  //LEs variables a utiliser

  private ArrayList<Object> L;
  private ArrayList<Object> M;
  private JLabel	 l[][]=new JLabel[4][4];
  private int a[][];
  private JLabel score;
  private int cpt;
//un jeu d'essaie
public void RemplireTab()
{
	 this.a=new int[4][4];
	a[0][3]=2;
	a[0][1]=2;
	a[1][0]=2;
	a[3][0]=2;
	
	
}

//1)Afficher dans une interface graphique notre tableau de jeu	

public void Interface2D()
{
	int a;
    int c=0;
	int b=120;
	String s;
	int i,j;
	this.cpt=0;
	//*************
   L=new ArrayList<Object>();
   M=new ArrayList<Object>();
	//*********
	setLayout(null);
	setTitle("Ma fenetre personnalisée");
	setBounds(400,100,490,600);  
	//**********
	score=new JLabel();
	score.setBounds(220, 30, 100, 40);
	s=""+cpt;
	score.setText(s);
    add(score);	
	//**********
	for( i=0;i<4;i++)
	{   a=39;
        
		for(j=0;j<4;j++)
		{
		l[i][j]=new JLabel();
	    l[i][j].setBounds(a,b, 100, 100);
	    s="                 "+this.a[i][j];
	    l[i][j].setText(s);

	    l[i][j].setBorder(BorderFactory.createBevelBorder(2));
	    add(l[i][j]);
			a=a+100;
		}
		b=b+100;
	}
	
    //*********

    addKeyListener(this);
    setVisible(true);
	colorer();
}


//2)Jouer à droite

public void JouerDroite()
{   
	int a,b,k,m;
	boolean B;
	for(int i=0;i<4;i++)
	{  
		
	
	        a=3;
			b=2;
			
	        while(a>0 && this.a[i][a]!=0 )
	        {
	        	if(this.a[i][a]==this.a[i][b])
	        	{
	        		
	        		this.a[i][a]=this.a[i][a]*2;
	        		this.cpt=this.a[i][a]+this.cpt;      	
	        		k=b;
	        		while(k>0)
	        		{
	        			this.a[i][k]=this.a[i][k-1];
	        			k--;
	        		}
	        		if(this.a[i][0]!=0){this.a[i][k]=0;
	        		b--;
	        		a--;
	        		
	        		}
	                         		
	        		
	        	}
	        	else
	        	{
	        		a--;
	        		b--;
	        	}
	        	
	        }								
	}
				
}
//*********fin********//


//3)decalage à droit

public void DecalageDroite()
{
	int T[]=new int[4];
	int  i ,j,k,m,c;
	
	for( i=0;i<4;i++)
	{  m=0;
	
		for(j=0;j<4;j++)
		{
			if(this.a[i][j]!=0)
			{		
				T[m]=this.a[i][j];	
				m++;
			}			
		}
		
		c=0;
	if(m!=4)
	{ 
		for(j=0;j<4-m;j++)
		{
			a[i][j]=0;
			
		}
		for(j=4-m;j<4;j++)
		{
			a[i][j]=T[c];
			c++;
		}
		
	}
	else
	{
		for(j=0;j<4;j++)
		{
			a[i][j]=T[c];
			c++;
		}
		
	}
		
				
	}	
}
//************Fin*****//

//4)decalage gauche

public void DecalageGauche()
{
	int T[]=new int[4];
	int  i ,j,k,m;
	
	for( i=0;i<4;i++)
	{  m=0;
		for(j=0;j<4;j++)
		{
			if(this.a[i][j]!=0)
			{
			
				T[m]=this.a[i][j];
				m++;
			}			
		}
		
		k=m;
		for(j=0;j<k;j++)
		{
			this.a[i][j]=T[j];
			
		}
	if(k<4)
	{

		for(j=k;j<4;j++)
		{
			a[i][j]=0;
			
			
		}	
	}
		
				
	}	
	
}



//*************Fin*************//
//5)decalage haut
public void DecalageHaut()
{
	int T[]=new int[4];
	int  i ,j,k,m;
	
	for( i=0;i<4;i++)
	{  m=0;
		for(j=0;j<4;j++)
		{
			if(this.a[j][i]!=0)
			{
			
				T[m]=this.a[j][i];
				m++;
			}			
		}
		k=m;
		for(j=0;j<k;j++)
		{
			this.a[j][i]=T[j];
		
			
		}
	if(k<4)
	{
		for(j=k;j<4;j++)
		{
			a[j][i]=0;
			
		}
	}
		
		
				
	}	
}
//6)decalage bas
public void DecalegeBas()
{
	int T[]=new int[4];
	int  i ,j,k,m,c;
	
	for( i=0;i<4;i++)
	{  m=0;
	
		for(j=0;j<4;j++)
		{
			if(this.a[j][i]!=0)
			{		
				T[m]=this.a[j][i];	
				m++;
			}			
		}
		
		c=0;
	if(m!=4)
	{ 
		for(j=0;j<4-m;j++)
		{
			a[j][i]=0;
			
		}
		for(j=4-m;j<4;j++)
		{
			a[j][i]=T[c];
			c++;
		}
		
	}
	else
	{
		for(j=0;j<4;j++)
		{
			a[j][i]=T[c];
			c++;
		}
		
	}
		
				
	}	
	
}

//**********Fin*************//
//7)jouer gauche
public void JouerGauche()
{

	int a,b,k,m;
	boolean B;
	for(int i=0;i<4;i++)
	{  
		
	
	        a=0;
			b=1;
			
	        while(a<3 && this.a[i][a]!=0 )
	        {
	        	if(this.a[i][a]==this.a[i][b])
	        	{
	        		
	        		this.a[i][a]=this.a[i][a]*2;
	        		this.cpt=this.a[i][a]+this.cpt;  
	        		k=b;
	        		while(k<3)
	        		{
	        			this.a[i][k]=this.a[i][k+1];
	        			k++;
	        		}
	        		this.a[i][3]=0;
	        		b++;
	        		a++;
	        		
	        		
	                         		
	        		
	        	}
	        	else
	        	{
	        		a++;
	        		b++;
	        	}
	        	
	        }								
	}
}
//**************Fin*************//
//8)jouer haut
public void JouerHaut()
{
	int a,b,k,m;
	boolean B;
	for(int i=0;i<4;i++)
	{  
		
	
	        a=0;
			b=1;
			
	        while(a<3 && this.a[a][i]!=0 )
	        {
	        	if(this.a[a][i]==this.a[b][i])
	        	{
	        		
	        		this.a[a][i]=this.a[a][i]*2;
	        		this.cpt=this.a[i][a]+this.cpt;  
	        		k=b;
	        		while(k<3)
	        		{
	        			this.a[k][i]=this.a[k+1][i];
	        			k++;
	        		}
	        		this.a[3][i]=0;
	        		b++;
	        		a++;
	        		
	        		
	                         		
	        		
	        	}
	        	else
	        	{
	        		a++;
	        		b++;
	        	}
	        	
	        }								
	}
}
//**************Fin*******************//
//9)jouer bas
public void JouerBas()
{
	int a,b,k,m;
	boolean B;
	for(int i=0;i<4;i++)
	{  
		
	
	        a=3;
			b=2;
			
	        while(a>0 && this.a[a][i]!=0 )
	        {
	        	if(this.a[a][i]==this.a[b][i])
	        	{
	        		
	        		this.a[a][i]=this.a[a][i]*2;
	        		this.cpt=this.a[i][a]+this.cpt;  
	        		k=b;
	        		while(k>0)
	        		{
	        			this.a[k][i]=this.a[k-1][i];
	        			k--;
	        		}
	        		if(this.a[0][i]!=0){this.a[k][i]=0;
	        		b--;
	        		a--;
	        		
	        		}
	                         		
	        		
	        	}
	        	else
	        	{
	        		a--;
	        		b--;
	        	}
	        	
	        }								
	}
}

//*************Fin*******************//

//11)Afficher un tableau 2D "a"

public void AffIn()
{int i,j;
String s;

	for( i=0;i<4;i++)
	{   
        
		for(j=0;j<4;j++)
		{
	
	    s="                 "+this.a[i][j];
	    l[i][j].setText(s);	    
		
		}
	}
	s=""+cpt;
	score.setText(s);
	
}
//***************Fin******************//

//12)Mettre un 2 dan la case vide
public void Mettre2(){
 Random r1=new Random();
 Random r2=new Random();
  boolean b,c;
  int i=0,j;
  b=false;
  for(i=0;i<4;i++)
  {
	  for(j=0;j<4;j++)
	  {
		  if(a[i][j]==0)b=true;
	  }
  }
 if(b==true){
  c=false;
  
  while( c==false)
  {
	  i=r1.nextInt(4);
	  j=r2.nextInt(4);
	  if(a[i][j]==0){a[i][j]=2;c=true;}
	 /* j=0;
	  while(j<4&&c==false)
	  {
		  if(a[i][j]==0)
		  {
			  a[i][j]=2;
			  c=true;
		  }
		  else
		  {
			  j++;
		  }
	  }
	  i++;*/
  }
 }
  }
	
	

//************Fin************//
//13)Colorer les case
public void colorer()
{
	for(int i=0;i<4;i++)
	{
		for(int j=0;j<4;j++)
		{
			
			switch(a[i][j])
			{
			case 0:l[i][j].setOpaque(true); l[i][j].setBackground(Color.cyan);break;case 2:l[i][j].setOpaque(true); l[i][j].setBackground(Color.LIGHT_GRAY);break;
			case 4:l[i][j].setOpaque(true); l[i][j].setBackground(Color.magenta);break;case 8:l[i][j].setOpaque(true); l[i][j].setBackground(Color.orange);break;
			case 16:l[i][j].setOpaque(true); l[i][j].setBackground(Color.green);break;case 32:l[i][j].setOpaque(true); l[i][j].setBackground(Color.PINK);break;
			case 64:l[i][j].setOpaque(true); l[i][j].setBackground(Color.RED);break;case 128:l[i][j].setOpaque(true); l[i][j].setBackground(Color.blue);break;
			case 256:l[i][j].setOpaque(true); l[i][j].setBackground(Color.darkGray);break;case 512:l[i][j].setOpaque(true); l[i][j].setBackground(Color.yellow);break;
			}
		}
		
		
	}
}
//14)Emplier la matrice
public void Empiler()
{   

   int[][] b=new int[4][4];
   for(int i = 0; i < 4; i++)
   {
 
     for (int j = 0; j <4; j++)
     {
       b[i][j] = a[i][j];
     }
   }
   M.add(cpt);
   L.add(b);
	
}
//************Fin**************//
//15)Depiler la matrice
public void Depiler()      
{    
	if(L.isEmpty()==false)
	{int[][] b=(int[][]) L.get(L.size()-1);
       L.remove(L.size()-1);
       a=b;
       cpt=(int)M.get(M.size()-1);
       M.remove(M.size()-1);
       String s=""+cpt;
   	 score.setText(s);
       
       AffIn();
       colorer();
	   }
  
}

//*************Fin****************//
@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
		 Empiler();  
		DecalageDroite();
        JouerDroite();
        Mettre2();
        colorer();
        AffIn(); 
       
        
       
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
    	 Empiler();  
        DecalageGauche();
        JouerGauche();
        Mettre2();
        AffIn();
        colorer(); 
       
        
    }
    if (e.getKeyCode() == KeyEvent.VK_UP) {  	
        Empiler();         
        DecalageHaut();
        JouerHaut();
        Mettre2();
        AffIn();
        colorer();   
       
        
        
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) { 
    	Empiler();
    	DecalegeBas();
    	JouerBas();
    	Mettre2();
        AffIn();
        colorer();
      
        
        
    }
    //************
    if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

    	 Depiler();
     


  
    }
    //**************

}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub


	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub


}

//aff
public void aff(int[][] a)
{    
	 System.out.println();
	for(int i=0;i<4;i++)
	{    System.out.println("|");
		for(int j=0;j<4;j++)
		{
			 System.out.print(a[i][j]+"|");			
		}
	}
}




}
