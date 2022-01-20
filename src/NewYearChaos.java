import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class NewYearChaos {

	public static void chos() {
		List<Integer> q = Arrays.asList(1 ,2 ,5 ,3 ,7 ,8 ,6 ,4);
		Integer [] a  = new Integer [q.size()];
		  for(int i=0;i<q.size(); i++) {
			  a[i]= q.get(i);
		  }
		
		minimumBribes(a);
		System.out.println(q);
	}

	public static void minimumBribes(Integer[] q) {
		int ans = 0;
        for(int i=q.length-1;i>=0;i--){
            int ch_pos = q[i]-(i+1);
            if(ch_pos>2) { System.out.println("Too chaotic");
            return; }
            else{
                //find starting index
                //range[num-2, arr.length] or 0 to length
                int st = Math.max(0,q[i]-2);
                for(int j=st;j<i;j++){
                    if(q[j]>q[i]) {
                    	ans++;
                    }
                }
            }
        }
        System.out.println(ans);
	}
}
