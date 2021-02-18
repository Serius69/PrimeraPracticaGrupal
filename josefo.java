package circular;
import java.util.Scanner;

import javax.swing.JOptionPane;
public class josefo {
   public static class circular{
	   int dato;
	   circular sgte;
   }
   public static Scanner teclado;
	public static void main(String[] args) {
	    teclado=new Scanner(System.in);
		circular cab=null;
		int opcion=0,m=0,n=0,x=0;
		do{

			opcion=leer("jUEGO DE LAS MONEDAS \n 
			11111 . AGREGAR CANTIDAD DE MONEDAS\n
			222222. LISTADO\n	
			33333.- JUGAR!!!\n
			44444.- Salir\n");
			switch(opcion)
			{
			case 1:
					m=leer("Monedasg123123");
					for(int i=1;i<=m;i++) {
						cab=agregar_lista(cab,i);
					}
				   break;
			case 2:
				if(cab!=null)
					listado("lista de monedas123123123: ",cab);
					break;
			case 3:
				int l=0,can=0,nn=0;
				if(cab!=null) {
					
				
				while(true) {
					l++;
					if(l%2==0) {
						listado("lista de monedas123123123: ",cab);
						do {
							can=leer("Turno del jugador 2\ncantidad de monedas que desea eliminar");
						}while(can!=1 && can!=2);
						if(can==1) {
							n=leer("numero de moneda a eliminar");
							cab=borrar(cab,n);
						}else {
							do{
								do {
									n=leer("numero de moneda a eliminar (1)");
								}while(true!=buscar(cab,n));
								do {
									nn=leer("numero de moneda a eliminar (2)");
								}while(true!=buscar(cab,nn));
							}while((n-nn)!=1 && (n-nn)!=-1);
							cab=borrar(cab,n);
							cab=borrar(cab,nn);
						}
						
						x=contar(cab);
						if(x==0) {
							JOptionPane.showMessageDialog(null,"GANADOR jugador 2");
							break;
						}
						
					}else {
						listado("la lista ciruclar es: ",cab);
						do {
							can=leer("Turno del jugador 1\ncantidad de monedas que desea eliminar");
						}while(can!=1 && can!=2);
						if(can==1) {
							n=leer("numero de moneda a eliminar");
							cab=borrar(cab,n);
						}else {
							do{
								do {
									n=leer("numero de moneda a eliminar (1)");
								}while(true!=buscar(cab,n));
								do {
									nn=leer("numero de moneda a eliminar (2)");
								}while(true!=buscar(cab,nn));
							}while((n-nn)!=1 && (n-nn)!=-1);
							cab=borrar(cab,n);
							cab=borrar(cab,nn);
						}
						
						x=contar(cab);
						if(x==0) {
							JOptionPane.showMessageDialog(null,"GANADOR jugador 1");
							break;
						}
					}
					
					
				}
				
				listado("la lista ciruclar es: ",cab);
				}
				break;
			}
			
		}while(opcion!=4);
	}
	
public static int contar(circular b)
	{
		int c=0;
		circular co=b;
		
		if(b!=null){
			while(co.sgte!=b)
			{
				c++;
				co=co.sgte;
			}
			c++;
			
		}
		return (c);
	}

public static boolean buscar(circular b,int n)
{
	circular co=b;
	boolean p=false;
	if(b!=null){
		while(co.sgte!=b)
		{
			if(co.dato==n) {
				p=true;
				break;
			}
			co=co.sgte;
		}
		if(co.dato==n) {
			p=true;
		}
	}
	return p;
}

public static void listado(String t, circular b)
{
	circular co=b;
	System.out.println(t);
	if(b!=null){
		while(co.sgte!=b)
		{
			System.out.print(co.dato+"\t");
			co=co.sgte;
		}
		System.out.println(co.dato);
	}
}

public static circular borrar(circular c, int x1)
{  circular a,d;
	circular co=c;
	
		a=c;
		d=c;
				if(d.sgte==co) {
					c=null;
				}else {
					if(d.dato==x1) {
						c=d.sgte;
						
						while(d.sgte!=co) {
						 d=d.sgte;	
						}
						d.sgte=c;
					}else {
						while(d.sgte!=c)
						{
							if(d.dato==x1) {
								
								a.sgte=d.sgte;
							}
							a=d;
							d=d.sgte;
							
						}
						
						if(d.dato==x1) {
							System.out.println("--- :"+d.dato);
							a.sgte=d.sgte;
						}
					}
					
				}
			
		
			
		
	
	return(c);
}
public static circular agregar_lista(circular c,int i)
{
	circular aux=nuevo(i);
	circular co;
	if(c==null){
		c=aux;
	}else
	{  co=c;
	   while(co.sgte!=c)
	   {
		   co=co.sgte;
	   }
	   co.sgte=aux;
	   aux.sgte=c;
	}
	return(c);
}
public static int leer(String t)
{
	int q=Integer.parseInt(JOptionPane.showInputDialog(t,"Seleccionar opcion"));
	return(q);
}
public static circular nuevo(int i)
{
	circular k=new circular();
	k.dato=i;
	k.sgte=k;
	return(k);
}
}
