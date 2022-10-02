import java.util.Arrays;

public class Main
{

	public static void main(String[] args)
	{
		int[] array_1 = {10, 4, 2, 8, 7, 3, 5, 9, 6, 1};
		int[] array_2 = {1, 6, 14, 13, 7, 2, 11, 10, 4, 9, 5, 8, 12, 3, 15};
		int[] array_3 = {8, 20, 16, 13, 15, 17, 12, 18, 19, 7, 10, 5, 4, 14, 2, 6, 1, 11, 9, 3};
		int a1 = array_1.length;
		int a2 = array_2.length;
		int a3 = array_3.length;	//array長度
		
		System.out.print("before sorting is ");
		System.out.println(Arrays.toString(array_1));	//列印所有array元素
		Quicksort(array_1, 0, a1-1);
		System.out.print("After sorting is  ");
		System.out.println(Arrays.toString(array_1));
		System.out.print("\n");
		System.out.print("-----------------------------------------\n\n");
		
		System.out.print("before sorting is ");
		System.out.println(Arrays.toString(array_2));
		Quicksort(array_2, 0, a2-1);
		System.out.print("After sorting is  ");
		System.out.println(Arrays.toString(array_2));
		System.out.print("\n");
		System.out.printf("-----------------------------------------\n\n");
		
		System.out.print("before sorting is ");
		System.out.println(Arrays.toString(array_3));
		Quicksort(array_3, 0, a3-1);
		System.out.print("After sorting is  ");
		System.out.println(Arrays.toString(array_3));
		System.out.print("\n");
	}
	
	public static void Quicksort(int[] A, int l, int r)
	{
		if(l < r)	//表示中間還有元素
		{
			//當 Subarray 元素個數小於等於 3 時，改用 InsertionSort 增進排序效率
			if(r-l+1 <= 3)
			{
				InsertionSort(A, l, r);
			}
			else
			{
				int s = HoarePartition(A, l, r);	//s is a split position
				Quicksort(A, l, s-1);	//左半邊
				Quicksort(A, s+1, r);	//右半邊
			}
		}
	}
	
	public static int HoarePartition(int[] A, int l, int r)
	{
		int p = A[l];	//取得pivot值
		int i = l;		//左
		int j = r;		//右
		
		while(i < j)	//還沒遇到
		{
			while(i < j && A[j] >= p)	//掃描:從右往左
			{
				j--;
			}
			
			while(i < j && A[i] <= p) 	//掃描:從左往右
			{
				i++;
			}
			
			//swap(A[i], A[j])
			int temp1 = A[i];
			A[i] = A[j];
			A[j] = temp1;
		}
		
		//swap(A[i], A[j])	//復原多餘對調
		int temp2 = A[i];
		A[i] = A[j];
		A[j] = temp2;
		
		//swap(A[l], A[j])	//p和A[j]對調
		int temp3 = A[l];
		A[l] = A[j];
		A[j] = temp3;
		
		System.out.print("Use partition:");
		System.out.println(Arrays.toString(A));
		return j;
	}
	
	public static void InsertionSort(int[] A, int l, int r)
	{
		int v = 0, j = 0;
		
		//For i←1 to n-1 do
		for(int i = l+1; i <= r; i++)	//從第l+1個元素(向右移)開始和左邊元素比較
		{
			v = A[i];	//目前要插入數字
			j = i - 1;	//目前比較位置
			
			while(j >= l && A[j] > v)	//由右往左,和v(A[i])比較,找到大的往右移動
			{
                A[j + 1]=A[j];	//搬到右側,空出空位
                j--;			//比較下一個(往左一格)
			}
			A[j + 1] = v;		//找到第一個A[j]<=v或到底了,STOP,將A[j+1]插入其右方
		}
		
		System.out.print("Use Insertion:");
		System.out.println(Arrays.toString(A));
	}
}