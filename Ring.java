import java.io.*;
import java.util.Scanner;

class Ring
{
	static int n ;
	static int elect ;
	static int coordinator ;
	static int array_index ;
	static int process[] = new int[100] ;
	static int array[] = new int[100] ;

	public static void main(String args[])
	{
		System.out.print( "\n Enter no of processes : " ) ;

		Scanner in = new Scanner(System.in);
        n = in.nextInt();

		for( int i = 1 ; i <= n ; i++ )
		{
			process[i] = 1 ;
			array[i] = -1 ;
		}

		System.out.print( "\n Current processes are : " ) ;

		for( int i = 1 ; i <= n ; i++ )
		{
			System.out.print( "p"+ i + "\t") ;
		}

		process[n] = -1 ;

		System.out.print( "\n\n Current coordinator is : p" + n ) ;

		System.out.print( "\n\n Which process detected the crash of coordinator : " ) ;
		elect = in.nextInt();

		System.out.print( "\n Process p"+ elect +" will start the election" ) ;

		System.out.print( "\n\n Election has started \n " ) ;

		array_index = 1 ;
		int i = elect ;
		int current_i = 0 ;
		int flag = 0 ;
		int max = 0 ;

		do
		{
			current_i = i % n ;

			for( int j = 1 ; j <= n+1 ; j++ )
			{
				if( current_i == array[j] && current_i != 0 )
				{
					flag = 1 ;
				}
			}

			if( flag != 1 && process[i] != -1 )
			{
				array[array_index] = i%n ;
				array_index++ ;
			}

			if( process[i] != -1 )
			{
				System.out.print( " \n Current array of p" + i%n + " : ") ;
			}

			for( int k = 1 ; k <= n ; k++ )
			{
				if( array[k] != -1 && process[i] != -1 )
				{
					System.out.print( "\t" + array[k] ) ;
				}
			}

			i++ ;

		}while( flag == 0 ) ;

		max = array[1] ;

		for( int j = 2 ; j <= n+1 ; j++ )
		{
			if( max < array[j] )
			{
				max = array[j] ;
			}
		}

		System.out.println( " \n\n Final coordinator is : p"+ max ) ;

		for( int j = 1 ; j < max ; j++ )
		{
			System.out.print( "\n Process p"+ max + " has send coordinator message to p" + j + "\n" ) ;
		}

		System.out.print( " \n " ) ;
	}
}


