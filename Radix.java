public class Radix{
/*
get nth digit of an int, where 0 is the ones column, 1 is the tens column etc.
nth(123,1) -> 2
nth(-123,1) -> 2
nth(123,2) -> 1
nth(-123,2) -> 1
*/
  public static int nth(int n, int col){
    return Math.abs(n / (int)Math.pow(10,col) % 10);
  }

/*
return the number of digits in n.
length(0) -> 1
length(15) -> 2
length(-10) -> 2
length(5112) -> 4
*/
  public static int length(int n){
    if(n==0) return 1;
    return (int)Math.log10(Math.abs(n))+1;
  }

/*
This requires your MyLinkedList file to be present locally, but please do not
commit this extra file.
Merge all of the linked lists in the bucket array into your original linked list.
The original may have elements, and those should be kept.
This is O(buckets.length) which should be 10 when we use this later.
The bucket[0] list will be merged first, then the bucket[1] etc.
*/
  public static void merge(SortableLinkedList original,SortableLinkedList[]buckets){
    for(int i=0;i<buckets.length;i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    SortableLinkedList[]buckets=new SortableLinkedList[10];
    for(int i=0;i<buckets.length;i++){
      buckets[i]=new SortableLinkedList();
    }
    int longest=0; //lenght of largest number
    for(int i=0;i<data.size();i++){ //LSD pass
      buckets[nth(data.get(i),0)].add(data.get(i));
      if(length(data.get(i))>longest) longest=length(data.get(i));
      data.remove(i);
      i--;
    }
    merge(data,buckets);
    //System.out.println(longest);
  }

  public static void radixSort(SortableLinkedList data){

  }

}
