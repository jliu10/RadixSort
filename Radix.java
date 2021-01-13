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
    int longest=0; //length of largest number
    while(data.size()>0){ //LSD pass
      int n=data.remove(0);
      buckets[nth(n,0)].add(n);
      if(length(n)>longest) longest=length(n);
    }
    merge(data,buckets);
    for(int i=1;i<longest;i++){
      while(data.size()>0){
        int n=data.remove(0);
        buckets[nth(n,i)].add(n);
      }
      merge(data,buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    SortableLinkedList[]buckets=new SortableLinkedList[19];
    for(int i=0;i<buckets.length;i++){
      buckets[i]=new SortableLinkedList();
    }
    int longest=0; //length of longest number
    while(data.size()>0){ //LSD pass
      int n=data.remove(0);
      if(n>=0) buckets[nth(n,0)+9].add(n);
      else buckets[9-nth(n,0)].add(n);
      if(length(n)>longest) longest=length(n);
    }
    //System.out.println(longest);
    merge(data,buckets);
    for(int i=1;i<longest;i++){
      while(data.size()>0){
        int n=data.remove(0);
        if(n>=0) buckets[nth(n,i)+9].add(n);
          else buckets[9-nth(n,i)].add(n);
      }
      merge(data,buckets);
    }
  }

}
