class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int key:nums){
            pq.add(key);
        }
        int ans = 0;
        for(int i=0;i<k;i++){
            ans = pq.remove();
        }
        
        return ans;
    }
}
class Solution {
    public String reorganizeString(String S) {
        Map<Character,Integer> map = new HashMap<>();
        for(char cc: S.toCharArray()){
            map.put(cc,map.getOrDefault(cc,0)+1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((x,y)->map.get(y)-map.get(x));
        pq.addAll(map.keySet());
        
        StringBuilder sb = new StringBuilder();
        
        while(pq.size() > 1){
            System.out.println(sb.toString());
            // System.out.println("Hello World");
            char cc1 = pq.remove();
            char cc2 = pq.remove();
            
            sb.append(cc1);
            sb.append(cc2);
            
            map.put(cc1,map.get(cc1)-1);
            map.put(cc2,map.get(cc2)-1);
            
            if (map.get(cc1) > 0){
                pq.add(cc1);
            }
            if(map.get(cc2) > 0){
                pq.add(cc2);
            }
            
        }
        
        if(pq.size()==1){
            char cc = pq.remove();
            int freq = map.get(cc);
            if (freq > 1){
                return "";
            }else{
                sb.append(cc);
            }
            
        }
        return sb.toString();
    }
}

public static ArrayList<Integer> mergeKsortedArrays(int[][] arr){
		ArrayList<Integer> ans = new ArrayList<>();

		PriorityQueue<help> pq = new PriorityQueue<help>();
		for(int[] ar: arr){
			pq.add(new help(ar,0));
		}

		while(!pq.isEmpty()){
			help temp  = pq.remove();
			ans.add(temp.arr[temp.index]);
			if(temp.index < temp.arr.length-1){
				pq.add(new help(temp.arr,temp.index+1));
			}
		}


		return ans;
	}
}

class help implements Comparable<help>{
	int[] arr;
	int index;
	public help(int[] arr, int index){
		this.arr = arr;
		this.index = index;
	}

	public int compareTo(help o){
		return this.arr[this.index]-o.arr[o.index];
	}
}

class Solution {
    public List<String> topKFrequentWords(String[] words, int k) {
        List<String> ans = new ArrayList<String>();
        Map<String,Integer> m = new HashMap<String,Integer>();
        for(String w: words){
            m.put(w,m.getOrDefault(w,0)+1);
        }
        
        PriorityQueue<String> freq[] = new PriorityQueue[words.length];
        for(int i=0;i<freq.length;i++){
            freq[i] = new PriorityQueue<String>();
        }
        
        for(String w: m.keySet()){
            freq[m.get(w)-1].add(w);
        }
        
        for(int i=freq.length-1;i>=0 && k>0; i--){
            while(k!=0 && !freq[i].isEmpty()){
                ans.add(freq[i].remove());
                k--;
            }
        }
        
        return ans;
    }
}

 public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        
        for(ListNode l: lists){
            if(l!=null){
                pq.add(l);
            }
        }
        
        ListNode dhead = new ListNode(-1);
        ListNode cur = dhead;
        
        while (!pq.isEmpty()){
            ListNode temp = pq.remove();
            cur.next = temp;
            cur = cur.next;
            if(temp.next!=null){
                pq.add(temp.next);
            }
        }
        
        
        
        return dhead.next;
        
    }

    
class Solution {
    public int[] topKFrequentElements(int[] nums, int k) {
        Map<Integer,Integer> m = new HashMap<>();
        int[] ans = new int[k];
        for(int key: nums){
            m.put(key,m.getOrDefault(key,0)+1);        
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->m.get(a)-m.get(b));
        for(int key:m.keySet()){
            pq.add(key);
            if(pq.size() > k){
                pq.remove();
            }
        }
        while (k-- >0){
            ans[k] = pq.remove();
        }
        
        return ans;
        
    }
}



class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((b[0]*b[0]+b[1]*b[1])-(a[0]*a[0]+a[1]*a[1])));
        for(int[] point: points){
            pq.add(point);
            if(pq.size() > k){
                pq.remove();
            }
        }
        
        while (k-- > 0){
            ans[k] = pq.remove();
        }
        
        return ans;
    }
}


