object Solution {
    def permuteUnique(nums: Array[Int]): List[List[Int]] = {
        /*
        [1,2,3,4]
        output
        [1,2,3,4]
        [1,3,2,4]
        [2,1,3,4]
        [2,3,1,4]
        [3,1,2,4]
        [3,2,1,4]
        [....
        recursion for brute force, one number at a time and try all permutations of n - 1 of the list
        n * n - 1 * n - 2 * ..... run time
       
       
       
       
       
       */
        
        //start with a set of list of Ints (set to assure no duplicates in the answer)
        var result = scala.collection.mutable.Set[List[Int]]()
        
        //private recurse function
        def recurse(first: Int): Unit = {
            //base case, if current index reaches last thing in list, add the current list to the result
            if(first == nums.size) result = result += nums.toList
            
            //loop through each index, and recurse
            for(i <- first until nums.length){
                //swap first index with index i
                var temp = nums(first)
                nums(first) = nums(i)
                nums(i) = temp
                
                //increase to go to next item in the list
                recurse(first + 1)
                
                //swap
                temp = nums(first)
                nums(first) = nums(i)
                nums(i) = temp
            }
        }
        
        //start at the first index of the list
        recurse(0)
        //since we need List[List[Int]] and we have Set[List[Int]], convert result to List
        result.toList
        
        
    }
}