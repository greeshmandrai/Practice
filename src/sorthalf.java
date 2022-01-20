import java.util.Arrays;

public class sorthalf {

	public void fdg() {
		int [] a= {1 ,2, 3, 4, 5 ,6 ,7};
		int n = 7;
		Arrays.sort(a);
        int mid = (n - 1)/2;

        int  temp = a [mid];
    	a[mid] = a[n-1];
    	a[n-1]= temp;

        for (int i = mid ; i< n-1; i++) {
        	for (int j = n-1 ; j> i; j--) {
        		if(a[j]> a[j-1]) {
            		temp = a [j];
                	a[j] = a[j-1];
                	a[j-1]= temp;
            	}
        	}
        }
        
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
	}
}
