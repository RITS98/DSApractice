import java.util.*;
import java.lang.*;
import java.io.*;
class permutation
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            permuteSol obj = new permuteSol();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
                        
        }
	}
}


class permuteSol {
    List<String> list = new ArrayList<String>();
    
    public void permute(String ques, String ansf)
    {
        if(ques.length() == 0)
        {
            list.add(ansf);
            return;
        }
        
        for(int i = 0;i<ques.length();i++)
        {
            char c = ques.charAt(i);
            String ros = ques.substring(0, i)+ques.substring(i+1);
            permute(ros, ansf+c);
        }
    }
    public List<String> find_permutation(String S) {
        permute(S, "");
        Collections.sort(list);
        return list;
    }
}