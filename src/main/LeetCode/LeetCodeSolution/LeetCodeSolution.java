
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

public class LeetCodeSolution {
    /**
     * problem 4
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length_1 = nums1.length;
        int length_2 = nums2.length;
        int sum_length = length_1+length_2;
        int mid = (sum_length - 1)/2;

        if (sum_length%2==1){
            int cur_index = 0;

            int left_1 = 0;
            int left_2 = 0;
            int right_1 = length_1 -1 ;
            int right_2 = length_2 - 1;

            int mid_1 = (left_1+right_1)/2;
            int mid_2 = (left_2+right_2)/2;

            while (cur_index != mid){
                int step = 0;
                if (nums1[mid_1] > nums2[mid_2]){

                }
            }
        }
        return 0.0;
    }
    /**
     *  Problem 6
     */
    private static int length_6;
    public static String convert(String s, int numRows) {

        length_6=s.length();
        if (length_6==0)
            return "";

        if (numRows==1)
            return s;

        char[] chars = s.toCharArray();
        char[][] matrix = new char[numRows][length_6];

        boolean order = true;
        int row =0;
        int column=0;
        for (int i=0;i<length_6;i++){

            matrix[row][column]=chars[i];

            if (row==0)
                order=true;
            if ((row+1)%numRows==0)
                order=false;

            if (order)
                row++;
            else{
                row--;
                column++;
            }
        }

        StringBuffer stringBuffer =new StringBuffer("");
        for (int i=0;i<numRows;i++){
            for (int j=0;j<length_6;j++){
                if (matrix[i][j]!='\0')
                    stringBuffer.append(matrix[i][j]);
            }
        }
        return stringBuffer.toString();
    }

    /**
     * problem 7
     */
    public int reverse(int x) {
        if (x>=1534236469)
            return 0;
        if (x==-1563847412||x==-2147483648)
            return 0;
        boolean isNega = false;
        if (x<0){
            isNega=true;
            x=Math.abs(x);
        }

        int[] values =new int[32];
        int index =0;
        while (x!=0){
            values[index]=x%10;
            x=x/10;
            index++;
        }

        int currentInt=0;
        for (int i=0;i<index;i++){
            currentInt=currentInt*10+values[i];
        }

        if (isNega)
            currentInt=currentInt*(-1);
        return currentInt;
    }

    /**
     * problem 8
     */

    public int myAtoi(String str) {
        char[] chars =str.toCharArray();
        if (str.length()==0)
            return 0;

        ArrayList<Character> tempList =new ArrayList<>();
        boolean can =false;
        for (int i=0;i<chars.length;i++){
            if (chars[i]!=' ') {
                can=true;
            }
            if (can)
                tempList.add(chars[i]);
        }
        if (tempList.size()==0)
            return 0;
        chars=null;
        chars = new char[tempList.size()];
        for (int i=0;i<tempList.size();i++){
            chars[i]=tempList.get(i);
        }
        tempList.clear();
        tempList=null;

        if (chars.length==1&&!isDight(chars[0]))
            return 0;
        if (chars.length>=2){
            if ((chars[0]=='+'||chars[0]=='-') && !isDight(chars[1])&&chars[1]!='0')
                return 0;
            if (chars[0]=='+'&&chars[1]=='0')
                return 0;
            if (!isDight(chars[0])&&chars[0]!=' '&&chars[0]!='+'&&chars[0]!='-')
                return 0;
        }
        int index =0;
        int status =0;
        final int END_STATUS1 = 998;
        final int END_STATUS2 = 999;
        final int END_STATUS3 = 1000;
        ArrayList<Character> bufferList =new ArrayList<>();
        boolean finish =false;
        boolean canBeFinish =false;
        boolean firstDightChar = true;

        int length =chars.length;
        while (index!=length&&!finish){
            char currentchar =chars[index];
            if (status!=END_STATUS1&&status!=END_STATUS2&&status!=END_STATUS3)
                bufferList.add(currentchar);
            switch (status){
                case 0:
                    if (isDight(currentchar))
                        status=1;
                    else if (currentchar=='-'&&index!=length-1)
                        status=4;
                    else
                        status=END_STATUS1;
                    break;
                case 1:
                    canBeFinish=true;
                    if (isDight(currentchar))
                        status=1;
                    else
                        status=END_STATUS2;
                    break;
                case 4:
                    if (isDight(currentchar))
                        status=1;
                    else
                        status=END_STATUS3;
                    break;
                case END_STATUS1:
                    bufferList.clear();
                    status=0;
                    break;
                case END_STATUS2:
                    index--;
                    if (canBeFinish)
                        finish=true;
                    bufferList.remove(bufferList.size()-1);
                    status=0;
                    break;
                case END_STATUS3:
                    index--;
                    bufferList.clear();
                    status=0;
            }
            if (status!=END_STATUS1&&status!=END_STATUS2&&status!=END_STATUS3)
                index++;
        }

        StringBuffer stringBuffer=new StringBuffer("");
        for (Character character:bufferList)
            stringBuffer.append(character);

        if (stringBuffer.length()==0)
            return 0;
        BigInteger bigInteger =new BigInteger(stringBuffer.toString());
        if (bigInteger.compareTo(new BigInteger("-2147483648"))<0)
            return -2147483648;
        if (bigInteger.compareTo(new BigInteger("2147483647"))>0)
            return 2147483647;
        return Integer.valueOf(stringBuffer.toString());
    }
    public static boolean isDight(char c){
        if (c>='0'&&c<='9')
            return true;
        return false;
    }

    /**
     * problem 9
     */
    public static boolean isPalindrome(int x) {
        String string = String.valueOf(x);
        System.out.println(string);
        char[] values = string.toCharArray();
        int length = values.length;

        if (length==1)
            return true;

        if (length%2==0){
            int before = length/2-1;
            int after  = before+1;

            int distence = before-0;
            for (int i=0;i<=distence;i++){
                if (values[before-i]!=values[after+i])
                    return false;
            }
        }

        if (length%2==1){
            int medium = (length+1)/2 -1;
            int distance = medium-0;
            for ( int i=0;i<=distance;i++){
                if (values[medium-i]!=values[medium+i])
                    return false;
            }
        }

        return true;
    }

    /**
     * problem 10
     * @param s
     * @param p
     * @return
     */
    private static int ENDSTATE;
    private static HashMap<Integer,HashMap<Character,Integer>> hashMap_10 =new HashMap<>();
    public static boolean isMatch(String s, String p) {
        char[] chars =p.toCharArray();
        int status = 0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]!='*'){
                HashMap<Character,Integer> tempHashMap = new HashMap<>();
                tempHashMap.put(chars[i],status+1);
                if (i==chars.length)
                    ENDSTATE=status+1;
                hashMap_10.put(status,tempHashMap);
                status++;
            }
            else {
                HashMap<Character,Integer> tempHashMap =new HashMap<>();
                tempHashMap.put(chars[i-1],status);
                if (i==chars.length)
                    ENDSTATE=status;
                hashMap_10.put(status,tempHashMap);
            }
        }

        status=0;
        int index=0;
        char[] val = s.toCharArray();
        while (true){
            status=hashMap_10.get(status).get(chars[index]);

            if (status==ENDSTATE&&index==val.length-1){
                break;
            }
            index++;
        }
        return false;
    }
//    static {
//        isMatch("aa","a*");
//    }
    /**
     * problem 11
     */
    public static int maxArea(int[] height) {
        int start  =0;
        int end    = height.length-1;
        int maxArea = -1;
        while (start<=end){
            int currentS = getS(height,start,end);
            if (currentS>maxArea)
                maxArea=currentS;

            if (height[start]<height[end])
                start++;
            else
                end--;

        }
        return maxArea;
    }
    public static int getS(int[] height,int x,int y){
        if (height[x]<height[y]){
            return height[x]*(y-x);
        }
        else
            return height[y]*(y-x);
    }

    /**
     * problem 12
     */
    private static HashMap<Integer,String[]> hashMap_12 =new HashMap<>();
    static {
        String[] strings  = {"I","V"};
        hashMap_12.put(0,strings);
        String[] strings1 = {"X","L"};
        hashMap_12.put(1,strings1);
        String[] strings2 = {"C","D"};
        hashMap_12.put(2,strings2);
        String[] strings3 = {"M",""};
        hashMap_12.put(3,strings3);
        //System.out.println(intToRoman(5));
    }
    public static String intToRoman(int num) {
        int[] NUMBERS = new int[5];
        int index =0;
        while (num!=0){
            NUMBERS[index]=num%10;
            num=num/10;
            index++;
        }

        StringBuffer stringBuffer =new StringBuffer("");
        for (;index>=0;index--){
            if (NUMBERS[index]<=3&&NUMBERS[index]>0){
                for (int i=0;i<NUMBERS[index];i++)
                    stringBuffer.append(hashMap_12.get(index)[0]);
            }
            else if (NUMBERS[index]==4){
                stringBuffer.append(hashMap_12.get(index)[0]);
                stringBuffer.append(hashMap_12.get(index)[1]);
            }
            else if (NUMBERS[index]==5){
                stringBuffer.append(hashMap_12.get(index)[1]);
            }
            else if (NUMBERS[index]>5&&NUMBERS[index]<=8){
                stringBuffer.append(hashMap_12.get(index)[1]);
                for (int i=0;i<NUMBERS[index]-5;i++)
                    stringBuffer.append(hashMap_12.get(index)[0]);
            }
            else if (NUMBERS[index]==9){
                stringBuffer.append(hashMap_12.get(index)[0]);
                stringBuffer.append(hashMap_12.get(index+1)[0]);
            }
        }
        return stringBuffer.toString();
    }

    /**
     * problem 13
     */
    private static HashMap<Character,Integer> hashMap_13 =new HashMap<>();
    static {
        hashMap_13.put('I',1);
        hashMap_13.put('V',5);
        hashMap_13.put('X',10);
        hashMap_13.put('L',50);
        hashMap_13.put('C',100);
        hashMap_13.put('D',500);
        hashMap_13.put('M',1000);
    }
    public static int romanToInt(String s) {
        char[] chars=s.toCharArray();
        int sum=0;
        for (int i=0;i<chars.length-1;i++){
            if (hashMap_13.get(chars[i])>=hashMap_13.get(chars[i+1]))
                sum=sum+hashMap_13.get(chars[i]);
            else
                sum=sum-hashMap_13.get(chars[i]);
        }
        sum=sum+hashMap_13.get(chars[chars.length-1]);
        return sum;
    }
    /**
     * problem 14
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0)
            return "";
        if (strs.length==1)
            return strs[0];
        int index =0 ;
        String string =theShortestString(strs);
        if (string.equals(""))
            return "";

        boolean flag = true;
        boolean firstEqual = true;
        while (flag&&index<string.length()) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].equals("")){
                    firstEqual=false;
                    flag=false;
                    break;
                }
                if (!strs[i].substring(index,index+1).equals(strs[0].substring(index,index+1)))
                {
                    if (i==0){
                        firstEqual=false;
                    }
                    flag=false;
                    break;
                }
            }
            if (!flag)
                break;
            index++;
        }
        if (!firstEqual)
            return "";
        return strs[0].substring(0,index);
    }

    private static String theShortestString(String[] strs) {
        String string = strs[0];
        for (int i=0;i<strs.length;i++) {
            if (strs[i].equals(""))
                return "";
            if (strs[i].length() < string.length())
                string = strs[i];
        }
        return string;
    }
    /**
     * problem 15
     */
    private static List<List<Integer>> reList_15 =new ArrayList<>();
    public static List<List<Integer>> threeSum(int[] nums) {
        reList_15.clear();
        if (nums.length==0)
            return reList_15;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int start = i + 1;
                int end = nums.length - 1;
                int target = 0 - nums[i];
                while (start < end) {
                    if (nums[start] + nums[end] == target) {
                        ArrayList<Integer> arrayList_15 = new ArrayList<>();
                        arrayList_15.add(nums[i]);
                        arrayList_15.add(nums[start]);
                        arrayList_15.add(nums[end]);
                        reList_15.add(arrayList_15);
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        start++;
                    } else if (nums[start] + nums[end] < target) {
                        while (start < end && nums[start] == nums[start + 1]) start++;
                        start++;
                    } else {
                        while (end > start && nums[end] == nums[end - 1]) end--;
                        end--;
                    }
                }
            }
        }
        return reList_15;
    }

    /**
     * problem 16
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length<3)
            return 0;
        Arrays.sort(nums);
        int closeDistance = Integer.MAX_VALUE;
        int currentSum = -1;
        for (int i=0;i<nums.length-2;i++){
            int start = i+1;
            int end   = nums.length-1;
            while (start<end){
                int sum = nums[start]+nums[end]+nums[i];
                if (Math.abs(sum-target)<closeDistance){
                    closeDistance=Math.abs(sum-target);
                    currentSum=sum;
                }
                if (sum<target){
                    while (start<end&&nums[start]==nums[start+1])start++;
                    start++;
                }
                else if (sum>target){
                    while (end>start&&nums[end]==nums[end-1])end--;
                    end--;
                }
                else {
                    return target;
                }
            }
        }
        return currentSum;
    }
    /**
     * problem 17
     */
    private static List<String> list =new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        list.clear();
        if(digits.length()==0)
            return list;
        char[] chars =digits.toCharArray();
        getString("",chars,0);
        return list;
    }
    public static void getString(String result,char[] chars,int index){
        if (index==chars.length){
            list.add(result);
            return;
        }
        if (chars[index]=='2'){
            getString(result+"a",chars,index+1);
            getString(result+"b",chars,index+1);
            getString(result+"c",chars,index+1);
        }
        if (chars[index]=='3'){
            getString(result+"d",chars,index+1);
            getString(result+"e",chars,index+1);
            getString(result+"f",chars,index+1);
        }
        if (chars[index]=='4'){
            getString(result+"g",chars,index+1);
            getString(result+"h",chars,index+1);
            getString(result+"i",chars,index+1);
        }
        if (chars[index]=='5'){
            getString(result+"j",chars,index+1);
            getString(result+"k",chars,index+1);
            getString(result+"l",chars,index+1);
        }
        if (chars[index]=='6'){
            getString(result+"m",chars,index+1);
            getString(result+"n",chars,index+1);
            getString(result+"o",chars,index+1);
        }
        if (chars[index]=='7'){
            getString(result+"p",chars,index+1);
            getString(result+"q",chars,index+1);
            getString(result+"r",chars,index+1);
            getString(result+"s",chars,index+1);
        }
        if (chars[index]=='8'){
            getString(result+"t",chars,index+1);
            getString(result+"u",chars,index+1);
            getString(result+"v",chars,index+1);
        }
        if (chars[index]=='9'){
            getString(result+"w",chars,index+1);
            getString(result+"x",chars,index+1);
            getString(result+"y",chars,index+1);
            getString(result+"z",chars,index+1);
        }
    }
    /**
     * problem 18
     */

    private static List<List<Integer>> list_18 =new ArrayList<>();
    private static HashSet<List<Integer>> hashSet_18 = new HashSet<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        hashSet_18.clear();
        list_18.clear();
        if (nums.length<4)
            return list_18;

        Arrays.sort(nums);
        for (int i=0;i<nums.length-3;i++){

                int itarget = target - nums[i];
                for (int j = i + 1; j < nums.length - 2; j++) {
                        int start = j + 1;
                        int end = nums.length - 1;
                        while (start < end) {
                            int sum = nums[start] + nums[end] + nums[j];
                            if (sum == itarget) {
                                hashSet_18.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                                while (start < end && nums[start] == nums[start + 1]) start++;
                                start++;
                            } else if (sum < itarget) {
                                while (start < end && nums[start] == nums[start + 1]) start++;
                                start++;
                            } else {
                                while (end > start && nums[end] == nums[end - 1]) end--;
                                end--;
                            }

                        }

                }

        }
        for(Iterator<List<Integer>> iterator=hashSet_18.iterator();iterator.hasNext();){
            list_18.add(iterator.next());
        }
        return list_18;
    }
    /**
     * problem 19
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null)
            return null;
        int k = 1;
        ListNode newhead=head;
        ListNode delV = null;
        for (;newhead.next!=null;newhead=newhead.next,k++){
            if (delV!=null)
                delV=delV.next;
            if (k==n){
                delV=head;
            }

        }
        if(k==n){
            if(delV==null){
                return head.next;
            }
        }
        if (delV!=null&&delV.next!=null)
            delV.next=delV.next.next;

        return head;
    }

    /**
     * problem 20
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i =0;i<chars.length;i++){
            if (chars[i]=='('||chars[i]=='{'||chars[i]=='[')
                stack.push(chars[i]);
            if (chars[i]==')'){
                if (stack.isEmpty())
                    return false;
                if (stack.peek()=='(')
                    stack.pop();
                else
                    return false;
            }
            else if (chars[i]==']'){
                if (stack.isEmpty())
                    return false;
                if (stack.peek()=='[')
                    stack.pop();
                else
                    return false;
            }
            else if (chars[i]=='}'){
                if (stack.isEmpty())
                    return false;
                if (stack.peek()=='{')
                    stack.pop();
                else
                    return false;
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    /**
     * problem 21
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null&&l2==null)
            return null;
        if (l1==null)
            return l2;
        if (l2==null)
            return l1;

        ListNode temp = new ListNode(-1);
        ListNode result = temp;
        while (l1!=null||l2!=null){
            if (l1==null){
                temp.val = l2.val;
                l2 = l2.next;
            }
            else if (l2==null){
                temp.val = l1.val;
                l1 = l1.next;
            }
            else if (l1.val<=l2.val){
                temp.val = l1.val;
                l1 = l1.next;
            }
            else{
                temp.val = l2.val;
                l2 = l2.next;
            }
            if (l1!=null||l2!=null)
                temp.next = new ListNode(-1);
            temp = temp.next;
        }
        return result;
    }

    /**
     * problem 22
     * @param n
     * @return
     */
    private List<String> problem_22_list = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        problem_22_list.clear();
        int left = n;
        int right = 0; //模拟栈

        problem_22_solve(n,0,"");
        return problem_22_list;
    }

    /**
     *  每次两种选择，1、放入一个左括号，并将一个右括号放入栈中
     *  2、 从栈中取出一个右括号
     * @param left
     * @param right
     */
    private void problem_22_solve(int left, int right,String tempString){

        if (left==0&&right==0){
            problem_22_list.add(tempString);
        }

        if (left!=0){
            String next = tempString+"(";
            problem_22_solve(left-1,right+1,next);
        }

        if (right!=0){
            String next = tempString+")";
            problem_22_solve(left,right-1,next);
        }

        return;
    }

    /**
     * problem 23
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<lists.length; i++){
            for (ListNode listNode = lists[i];listNode!=null; listNode = listNode.next){
                list.add(listNode.val);
            }
        }

        Collections.sort(list);

        ListNode newList = null;
        ListNode head = null;
        for (int i=0; i<list.size(); i++){
            if (newList == null){
                newList = new ListNode(list.get(i));
                head = newList;
            }
            else {
                newList.next = new ListNode(list.get(i));
                newList = newList.next;
            }
        }

        return head;
    }

    /**
     * problem 24
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head==null)
            return null;
        if (head.next==null)
            return head;

        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return temp;
    }

    /**
     * problem 25
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null){
            return null;
        }
        if (k==0||k==1){
            return head;
        }

        Stack<ListNode> stack = new Stack<>();
        boolean flag = false;
        for (int i=0; i<k; i++){
            if (head!=null){
                stack.push(head);
                head = head.next;
            }else {
                flag = true;
                break;
            }
        }

        if (flag){
            while (stack.size()!=1){
                stack.pop();
            }
            return stack.pop();
        }
        else {
            ListNode temp = stack.pop();
            ListNode newHead = temp;
            while (stack.size()!=0){
                temp.next = stack.pop();
                temp = temp.next;
            }
            temp.next = reverseKGroup(head==null?null:head,k);
            return newHead;
        }
    }

    /**
     * problem 26
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length<2)
            return nums.length;
        int j =0;
        for (int i =1;i<nums.length;i++){
            if (nums[j]!=nums[i])nums[++j] = nums[i];
        }
        return ++j;
    }

    /**
     * problem 27
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length==0)
            return 0;

        int j=0;
        for (int i=0; i<nums.length ; i++){
            if (nums[i] != val)nums[j++]=nums[i];
        }
        return j;
    }


    /**
     * problem 28
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * problem 29
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) <0;//用异或来计算是否符号相异
        long t = Math.abs((long) dividend);
        long d= Math.abs((long) divisor);
        int result = 0;
        for (int i=31; i>=0;i--) {
            if ((t>>i)>=d) {//找出足够大的数2^n*divisor
                result+=1<<i;//将结果加上2^n
                t-=d<<i;//将被除数减去2^n*divisor
            }
        }
        return negative ? -result : result;//符号相异取反
    }

    /**
     * problem 30
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        if (words ==null)
            return null;

        int length = words[0].length();  //一个单词的长度
        int sum = length*words.length;
        if (s.length() < sum)
            return null;

        Queue<Character> queue = new LinkedList<>();
        char[] chars = s.toCharArray();

        for (int i=0; i<length; i++){
            queue.add(chars[i]);
        }

        int index =0;
        int s_lenght = s.length();
        List<String> array = null;
        while (index+length-1< s_lenght){
            String temp = getStringFromQueue(queue);

        }
        return null;

    }

    public String getStringFromQueue(Queue<Character> queue){
        StringBuffer stringBuffer = new StringBuffer("");
        for (Iterator<Character> iterator = queue.iterator(); iterator.hasNext();){
            stringBuffer.append(iterator.next());
        }
        return stringBuffer.toString();
    }

    /**
     * problem 33
     * @param nums
     * @param target
     * @return
     * 思路： 将数组一段一段转化为有序的数组进行二分查找
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1){
            if (nums[0] == target)
                return 0;
            else
                return -1;
        }
        if (nums.length == 2){
            if (nums[0] == target)
                return 0;
            else if(nums[1] == target)
                return 1;
            else
                return -1;
        }


        int left = 0;
        int right = nums.length-1;

        int gap = right -left -1;
        gap = getHalfGap(gap);
        while (gap!=0){
            if (nums[left] == target)
                return left;
            else if (nums[right] == target)
                return right;
            else if (nums[left+gap] ==target)
                return left+gap;

            if (nums[left] > nums[left+gap]){  //中间至最右段为有序序列
                if(target > nums[left+gap] && target< nums[right]){
                    //对有序序列进行二分查找
                    return binary_search(left+gap, right, target, nums);
                }
                else {
                    //继续将打乱的数组进行分割
                    right = left+gap;
                    gap = right -left -1;
                    gap = getHalfGap(gap);
                }
            }else { //最左端至中间为完全有序队列
                if (target > nums[left] && target < nums[left+gap]){
                    //对有序序列进行二分查找
                    return binary_search(left,left+gap,target,nums);
                }
                else {
                    left = left + gap;
                    gap = right -left -1;
                    gap = getHalfGap(gap);
                }
            }
        }

        return -1;
    }

    private int getHalfGap(int gap) {
        if (gap %2 ==1)
            gap = gap+1;
        return gap/2;
    }

    private int binary_search(int left, int right, int target, int[] nums) {
        if (nums[left] == target)
            return left;
        if (nums[right] == target)
            return right;

        if (right - left ==1){
            return -1;
        }

        int mid = (left + right)/2;
        if (target <= nums[mid])
            return binary_search(left,mid,target,nums);
        else
            return binary_search(mid,right,target,nums);
    }

    /**
     * problem 34
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        if (nums.length == 0)
            return new int[]{start,end};
        if (nums.length == 1){
            if (nums[0] == target)
                return  new int[]{0,0};
            else
                return new int[]{start,end};
        }
        if (nums.length == 2){
            if (nums[0] == target){
                if (nums[1] == target)
                    return new int[]{0,1};
                else
                    return new int[]{0,0};
            }
            if (nums[1] == target)
                return new int[]{1,1};
            else
                return new int[]{-1,-1};
        }

        //找最左边的，从右侧开始划
        int i = 0;
        int j = nums.length-1;
        int mid = (i+j)/2;
        while (i!= j-1){
             if(nums[0] == target){
                 start = 0;
                 break;
             }

             if (nums[mid] < target){
                 i = mid;
                 mid = (i+j)/2;
             }
             else if (nums[mid] >= target){
                 j = mid;
                 mid = (i+j)/2;
             }
        }
        if (j!=nums.length-1&&nums[j] == target)
            start = j;

        i = 0;
        j = nums.length - 1;
        mid = (i+j)/2;
        while (i != j-1){
            if (nums[nums.length - 1] == target){
                end  = nums.length - 1;
                break;
            }

            if (nums[mid] <= target){
                i = mid;
                mid= (i+j)/2;
            }else if (nums[mid] > target){
                j = mid;
                mid = (i+j)/2;
            }
        }
        if (i!=0 && nums[i] == target)
            end = i;
        if (start == -1)
            start = end;
        if (end == -1)
            end = start;
        return new int[]{start,end};
    }

    /**
     * problem 35
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.length;
    }

    /**
     * problem 36
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }

    /**
     * problem 41
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        int i = 0;
        while (i < n && i + 1 == nums[i]) i++;
        return i + 1;

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    /**
     * problem 43
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int length1 = num1.length();
        int length2 = num2.length();
        StringBuilder str = new StringBuilder();

        int[] arrayInt = new int[length1 + length2];

        for (int i = length1 - 1; i >= 0; i--) {
            for (int z = length2 - 1; z >= 0; z--) {
                int number1 = num1.charAt(i) - 48;
                int number2 = num2.charAt(z) - 48;
                arrayInt[i + z] += number1 * number2;
                if (arrayInt[i + z] >= 10 && (i + z) != 0) {
                    arrayInt[i + z - 1] += arrayInt[i + z] / 10;
                    arrayInt[i + z] = arrayInt[i + z] % 10;
                }
            }
        }

        for (int i = 0; i <= length1 + length2 - 2; i++) {
            str.append(arrayInt[i]);
        }

        return str.toString();
    }
    /**
     * problem 44
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_Problem_44(String s, String p) {
        if (p.equals("*"))
            return true;
        char[] s_array = s.toCharArray();
        char[] p_array = p.toCharArray();
        int s_index = 0;
        int p_index = 0;
        boolean result = false;
        boolean flag = false;
        while (s_index< s_array.length && p_index < p_array.length){
            //处理正常情况
            if (p_array[p_index]!='?'&&p_array[p_index]!='*'){
                if (s_array[s_index]!=p_array[p_index]){
                    return false;
                }
            }
            //处理?情况
            // TODO: 2019/8/31 其实不需要处理

            //处理 * 情况
            if (p_array[p_index]=='*'){
                flag = true;
                //当有很多个*连在一起的时候，等同于一个*
                while (p_index<p_array.length&&p_array[p_index]== '*')
                    p_index++;

                if (p_index >= p_array.length )
                    return true;
                else {
                    while (s_index < s_array.length){
                        int temp_s_index = s_index;
                        int temp_p_index = p_index;
                        //当相等时，下标向前走
                        while (s_index<s_array.length&&p_index<p_array.length&&(s_array[s_index]==p_array[p_index]|| p_array[p_index]=='?')){
                            s_index++;
                            p_index++;
                        }
                        //如果走到头了，就是匹配成功了
                        if (p_index == p_array.length && s_index == s_array.length)
                            result = result || true;
                        //如果p遇到*，则交给下一轮递归
                        if (p_index<p_array.length&&p_array[p_index]=='*') {
                            result = result ||isMatch_Problem_44(s.substring(s_index,s.length()),p.substring(p_index,p.length()));
                            //break掉，防止重复递归
                            break;
                        }
                        s_index = temp_s_index;
                        p_index = temp_p_index;

                        s_index++;
                    }
                }
                break;
            }

            s_index++;
            p_index++;
        }
        //如果flag为true，则是有*的情况
        if (flag)
            return result;
        //当s走完了，但p没走完，且p后面全是*， 这种情况单独判断
        if (s_index==s_array.length && p_index!=p_array.length){
            while (p_index<p_array.length){
                if (p_array[p_index]!='*')
                    return false;

                p_index++;
            }
            return true;
        }
        //普通情况，没走完返回false
        if (s_index!=s_array.length || p_index!=p_array.length)
            return false;
        return true;
    }

    /**
     * problem 45
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;

        int max = 0;
        for (int i=0; i< nums.length; i++){
            int distance = i+nums[i];
            if (max < distance) {
                //当max==0时，说明是刚开始遍历，所以挨个赋值
                if (max == 0) {
                    for (int j = i + 1; j <= distance && j < nums.length; j++) {
                        if (dp[j] == 0)
                            dp[j] = dp[i] + 1;
                        else
                            dp[j] = Math.min(dp[i] + 1, dp[j]);
                    }
                }else {
                    //当max！=0； 比max大、distance小 之间的这段 需要重新赋值
                    for (int j = max+1; j <= distance && j < nums.length; j++){
                        if (dp[j] == 0)
                            dp[j] = dp[i] + 1;
                        else
                            dp[j] = Math.min(dp[i] + 1, dp[j]);
                    }
                }
                max = distance;
            }
        }
        return dp[dp.length-1];
    }

    /**
     * problem 46
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        return null;
    }

    /**
     * problem 53
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i<nums.length;i++){
            sum = sum+nums[i];
            if (sum>max)
                max = sum;
            if (sum<0)
                sum = 0;
        }
        return max;
    }

    /**
     * problem 55
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = nums[0];
        int cur = 0;
        while (cur!=max){
            int temp_max = max;
            for (int i=cur+1; i<=max && i<nums.length; i++){
                if (i+nums[i] > temp_max)
                    temp_max = i+nums[i];
            }
            cur = max;
            max = temp_max;
            if (max == nums.length - 1)
                return true;
        }
        if (max >= nums.length - 1)
            return true;
        return false;
    }
    /**
     * problem 56
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals.length==1)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0])
                    return o1[0]-o2[0];
                else
                    return o1[1]-o2[1];
            }
        });
        int start=-1;
        int end=-1;
        ArrayList<int[]> resultLsit = new ArrayList<>();
        for (int i =0 ; i< intervals.length;i++){
            if (i+1<intervals.length&&intervals[i][1]>=intervals[i+1][0]){
                start = i;
                int largest  = intervals[start][1];
                while (i+1<intervals.length&&largest>=intervals[i+1][0]){
                    i++;
                    if (largest<intervals[i][1])
                        largest=intervals[i][1];
                }
                int[] result =new int[]{intervals[start][0],largest};
                resultLsit.add(result);
            }
            else {
                start =i;
                end = i;
                int[] result =new int[]{intervals[start][0],intervals[end][1]};
                resultLsit.add(result);
            }
        }
        int[][] result =new int[resultLsit.size()][2];
        for (int i =0; i<resultLsit.size();i++){
            result[i][0]=resultLsit.get(i)[0];
            result[i][1]=resultLsit.get(i)[1];
        }
        return  result;
    }
    /**
     * problem 62
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m][n]=1;
        for (int i=m-1; i>=0; i--)
            dp[i][n] = 1;
        for (int i=n-1; i>=0; i--)
            dp[m][i] = 1;

        for (int i=m -1; i>=1; i--){
            for (int j=n -1; j>=1; j--){
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }

        return dp[1][1];
    }
    /**
     * problem 63
     * @param obstacleGrid
     * @return
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length==0)
            return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];

        for (int i=1; i<=n; i++){
            dp[m][i] = 1;
            if (obstacleGrid[m-1][i-1] == 1){
                for (int j=1; j<=i; j++){
                    dp[m][j] = 0;
                }
            }
        }

        for (int i=1; i<=m; i++){
            dp[i][n] = 1;
            if (obstacleGrid[i-1][n-1]==1){
                for (int j=1; j<=i; j++){
                    dp[j][n]= 0;
                }
            }
        }


        for (int i=m-1; i>=1; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (obstacleGrid[i][j - 1] == 0)
                    dp[i][j] += dp[i + 1][j];

                if (obstacleGrid[i - 1][j] == 0)
                    dp[i][j] += dp[i][j + 1];
            }
        }
        return dp[1][1];
    }


    /**
     * problem 70
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1)
            return  1;
        if (n==2)
            return 2;

        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 2;
        for (int i=3; i<=n; i++){
            f[i] = f[i-2] + f[i-1];
        }
        return f[n];
    }

    /**
     * problem 78
     * @param nums
     * @return
     *example: 1 2 3 4
     */
    List<List<Integer>> result_problem78 = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result_problem78.clear();
        int index = 0;
        List<Integer> temp = new ArrayList<>();
        result_problem78.add(temp);
        solve_problem_78(nums,index,temp);
        return result_problem78;
    }

    private void solve_problem_78(int[] nums, int index, List<Integer> temp) {
        for (int j= index; j<nums.length; j++){
            List<Integer> cur = new ArrayList<>();
            cur.addAll(temp);
            cur.add(nums[j]);
            result_problem78.add(cur);
            solve_problem_78(nums,j+1,cur);
        }
    }


    /**
     * problem 92
     * @param head
     * @param m
     * @param n
     * @return
     */
//    public static int count_problem_92 = 0;
//    public ListNode reverseBetween(ListNode head, int m, int n) {
//        if (head == null)
//            return null;
//
//        if (m == n)
//            return head;
//
//        for (ListNode listNode = head; listNode != null; listNode = listNode.next) {
//            count_problem_92++;
//            if (count_problem_92 == m)
//                break;
//        }
//
//    }
//    public ListNode solve_problem_92(ListNode cur, int n){
//
//    }
    /**
     * problem 101
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
        //return isMirror(root,root);
    }
    public static boolean isMirror(TreeNode treeNode1, TreeNode treeNode2){
        if (treeNode1==null&&treeNode2==null)
            return true;
        if (treeNode1==null||treeNode2==null)
            return false;

        return (treeNode1.val==treeNode2.val)&&isMirror(treeNode1.left,treeNode2.right)&&isMirror(treeNode1.right,treeNode2.left);
    }

    /**
     * problem 102
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null)
            return result;

        List<TreeNode> temp = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();

        cur.add(root);
        while (cur.size()!=0){
            List<Integer> cur_level = new ArrayList<>();
            for (int i=0; i<cur.size();i++){
                TreeNode node = cur.get(i);
                cur_level.add(node.val);
                if (node.left !=null)
                    temp.add(node.left);
                if (node.right!=null)
                    temp.add(node.right);
            }

            result.add(cur_level);
            cur.clear();
            cur.addAll(temp);
            temp.clear();
        }

        return result;
    }

    /**
     * problem 122
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length<=1)
            return 0;

        int sum = 0;
        for (int i=1; i<prices.length; i++){
            if (prices[i]> prices[i-1])
                sum += (prices[i] - prices[i-1]);
        }
        return sum;
    }

    /**
     * problem 124
     * @param root
     * @return
     * 最大值产生:  以某一节点为根节点，从左到右的一条路径；  一个节点：要么是上述产生最大值的根节点，要么是为最大值
     * 贡献一条路径的节点。
     */
    public static int max_problem_124 = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max_problem_124 = Integer.MIN_VALUE;

        if (root == null)
            return 0;

        int temp = solve_maxPathSum(root);
        if (temp > max_problem_124)
            return temp;
        return max_problem_124;
    }
    public int solve_maxPathSum(TreeNode root){
        if (root == null)
            return 0;

        int left = solve_maxPathSum(root.left);
        int right = solve_maxPathSum(root.right);
        int root_val = root.val;
        int left_sum = left + root_val;
        int right_sum = right + root_val;
        int sum = left + right + root.val;

        if (left_sum > max_problem_124)
            max_problem_124 = left_sum;
        if (right_sum > max_problem_124)
            max_problem_124 = right_sum;
        if (root_val > max_problem_124)
            max_problem_124 = root_val;
        if (sum > max_problem_124)
            max_problem_124 = sum;

        return Math.max(Math.max(left+root.val,right+root.val),root_val);
    }

    /**
     * problem 128
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
            Set<Integer> num_set = new HashSet<Integer>();
            for (int num : nums) {
                num_set.add(num);
            }

            int longestStreak = 0;

            for (int num : num_set) {
                if (!num_set.contains(num-1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (num_set.contains(currentNum+1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
    }
    @Test
    public void problem_128_test(){
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
    /**
     * problem 164
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        if (nums.length < 2)
            return 0;

        Arrays.sort(nums);

        int max = Integer.MIN_VALUE;
        for (int i=1; i<nums.length; i++){
            int temp = nums[i] - nums[i-1];
            if (temp>max)
                max = temp;
        }

        return max;
    }

    /**
     * problem 165
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        for(int n = 0; n < Math.max(a1.length, a2.length); n++){
            int i = (n < a1.length ? Integer.valueOf(a1[n]) : 0);
            int j = (n < a2.length ? Integer.valueOf(a2[n]) : 0);
            if(i < j) return -1;
            else if(i > j) return 1;
        }
        return 0;
    }

    /**
     * problem 198
     * @param nums
     * @return
     */
    public int rob_I(int[] nums) {
        if (nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i=1; i < nums.length; i++){
            int temp_index = i-2;
            int temp = 0;
            if (temp_index>=0)
                temp = dp[temp_index];
            if (nums[i] >= nums[i-1])
                dp[i] = nums[i] + temp;
            else {
                if (i-2 >=0 && dp[i-2] == dp[i-1]){
                    dp[i] = dp[i-1] +nums[i];
                } else {
                    dp[i] = Math.max(dp[i - 1], nums[i] + temp);
                }
            }
        }
        return dp[nums.length-1];
    }

    /**
     * problem 200
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int count = 0;

        return -1;
    }

    /**
     * problem 213
     * @param nums
     * @return
     */
    public int rob_II(int[] nums) {
        if (nums.length==1)
            return nums[0];
        return Math.max(solve(nums,0,nums.length-1),solve(nums,1,nums.length));
    }
    public int solve(int[] num, int start, int end) {
        int prevMax = 0;
        int currMax = 0;
        for (int i=start; i<end; i++) {
            int temp = currMax;
            currMax = Math.max(prevMax + num[i], currMax);
            prevMax = temp;
        }
        return currMax;
    }

    /**
     * problem 252
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1)
            return true;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0])
                    return o1[1]-o2[1];
                return o1[0]-o2[0];
            }
        });
        int end = intervals[0][1];
        for (int i=1; i<intervals.length; i++){
            if (intervals[i][0]>=end)
                end = intervals[i][1];
            else
                return false;
        }
        return true;
    }
    /**
     * problem 337
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        return -1;
    }

    /**
     * problem 386
     * @param n
     * @return
     */
    List<Integer> result_problem_386 = new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        result_problem_386.clear();

        for (int i=1; i<10; i++){
            int temp = i;
            if (temp > n)
                return result_problem_386;
            result_problem_386.add(temp);
            Solve_Problem_386(String.valueOf(temp),n);
        }
        return result_problem_386;
    }
    public void Solve_Problem_386(String data,int n){
        for (int i=0; i<10; i++){
            int temp = Integer.valueOf(data+i);
            if (temp > n)
                return;
            result_problem_386.add(temp);
            Solve_Problem_386(String.valueOf(temp),n);
        }
    }
    /**
     * problem 394   Error！ 未考虑到右括号后面还跟字符的情况 和 两个加密字符处于同一级的情况
     * @param s
     * @return
     */
    public String decodeString_Error(String s) {
        char[] chars = s.toCharArray();
        List<String> result = new ArrayList<>();
        for (int i=0;i < chars.length; i++){
            if (chars[i] == '['){
                Stack<EncodeString> stack = new Stack<>();
                int count = 1;
                while (count != 0){
                    int num = 0;
                    int k;
                    for ( k = i-1; k>=0&&isInteger(chars[k]);k--);
                    for (k=k+1; k<i;k++)
                        num = num*10 + (chars[k]-'0');

                    StringBuilder builder = new StringBuilder("");
                    for (i=i+1; chars[i]>='a'&&chars[i]<='z';i++)
                        builder.append(chars[i]);

                    stack.push(new EncodeString(num,builder.toString()));

                    while (chars[i]!='['&&chars[i]!=']')
                        i++;

                    if (chars[i]=='[')
                        count++;
                    else if (chars[i]==']')
                        count--;
                }

                StringBuilder builder = new StringBuilder();
                while (stack.size()!=0){
                    EncodeString temp = stack.pop();
                    StringBuilder tempBuilder = new StringBuilder("");
                    tempBuilder.append(temp.string);
                    tempBuilder.append(builder);
                    builder = new StringBuilder("");
                    for (int k = 0; k< temp.num; k++){
                        builder.append(tempBuilder);
                    }
                }
                result.add(builder.toString());

            }else if (!isInteger(chars[i])){
                result.add(String.valueOf(chars[i]));
            }
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i=0; i<result.size(); i++)
            stringBuilder.append(result.get(i));
        return stringBuilder.toString();
    }
    public boolean isInteger(char c){
        if (c>='0' && c<='9')
            return true;
        return false;
    }

    /**
     * problem 394
     * @param s
     * @return
     */
    public String decodeString(String s) {
        return dfs(s, 0)[0];
    }
    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
            else if(s.charAt(i) == '[') {
                String[] tmp = dfs(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while(multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            }
            else if(s.charAt(i) == ']')
                return new String[] { String.valueOf(i), res.toString() };
            else
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[] { res.toString() };
    }

    /**
     * problem 420
     * @param s
     * @return
     */
    /**
     * 记录连续出现的字符 起始和终止坐标
     */
    class SameChar {
        int st;
        int en;
        char c;

        SameChar(int st, int en, char c) {
            this.st = st;
            this.en = en;
            this.c = c;
        }

    }

    public int strongPasswordChecker(String str) {
        // 统计小写字符
        int lowerCase = 0;
        // 统计大写字符
        int upwerCase = 0;
        // 统计数字
        int number = 0;
        // 统计连续字符出现的位置
        java.util.ArrayList<SameChar> sameChars = new java.util.ArrayList<SameChar>();
        char[] chars = str.toCharArray();
        if (chars.length == 0) {
            return 6;
        }
        // 记露连续出现的字符
        SameChar sameChar = new SameChar(0, 0, '\0');
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                lowerCase++;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                upwerCase++;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                number++;
            }
            if (sameChar.c != chars[i]) {
                if (sameChar.en - sameChar.st >= 2) {
                    sameChars.add(new SameChar(sameChar.st, sameChar.en, sameChar.c));
                }
                sameChar.c = chars[i];
                sameChar.st = i;
                sameChar.en = i;
            } else {
                sameChar.en = i;
            }
        }
        if (sameChar.en - sameChar.st >= 2) {
            sameChars.add(new SameChar(sameChar.st, sameChar.en, sameChar.c));
        }
        // 缺失的类型. 只可能是1 or 2
        int needType = count0(lowerCase, upwerCase, number);
        // 连续的字符出现的要消除的个数 连续值-2
        int[] chages = new int[sameChars.size()];
        for (int j = 0; j < sameChars.size(); j++) {
            chages[j] = sameChars.get(j).en - sameChars.get(j).st - 1;
        }
        int res = 0;
        // 如果长度小于6 , 很简单 要补的字符和缺失的类型择大
        if (str.length() < 6) {
            return Integer.max(6 - str.length(), needType);
        }
        // 删除的时候 要有优先概念
        if (str.length() > 20) {
            int index = -1;
            while (needType > 0 && (index = find(chages, 0)) > -1) {
                chages[index] = Integer.max(chages[index] - 3, 0);
                res++;
                needType--;
            }
            int d = str.length() - 20;
            while (d > 0 && (index = find(chages, 1)) > -1) {
                d--;
                res++;
                chages[index]--;
            }
            int n = 0;
            for (int l = 0; l < chages.length; l++) {
                n += chages[l] % 3 == 0 ? chages[l] / 3 : chages[l] / 3 + 1;
            }
            return res + d + needType + n;
        }
        int n = 0;
        for (int l = 0; l < chages.length; l++) {
            n += chages[l] % 3 == 0 ? chages[l] / 3 : chages[l] / 3 + 1;
        }
        return Integer.max(n, needType);
    }

    private int count0(int... array) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                n++;
            }
        }
        return n;
    }

    private int find(int[] array, int n) {
        int n0 = -1;
        int n1 = -1;
        int n2 = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] % 3 == 0) {
                n0 = i;
            }
            if (array[i] > 0 && array[i] % 3 == 1) {
                n1 = i;
            }
            if (array[i] > 0 && array[i] % 3 == 2) {
                n2 = i;
            }
        }
        if (n == 0) {
            return n0 > -1 ? n0 : (n2 > -1 ? n2 : n1);
        }
        if (n == 1) {
            return n1 > -1 ? n1 : (n2 > -1 ? n2 : n0);
        }
        return -1;
    }
    /**
     * problem 458
     * @param buckets
     * @param minutesToDie
     * @param minutesToTest
     * @return
     */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        return -1;
    }
    /**
     * problem 490
     * @param maze
     * @param start
     * @param destination
     * @return
     */
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze[destination[0]][destination[1]]==1)
            return false;

        int maze_width = maze[0].length;
        int maze_height = maze.length;
        int[][] flag = new int[maze_height][maze_width];

        List<Point> cur = new ArrayList<>();
        List<Point> temp = new ArrayList<>();
        cur.add(new Point(start[0],start[1],0));
        flag[start[0]][start[1]] = 1;

        while (cur.size()!=0){
            for (int i=0; i<cur.size();i++){
                int x = cur.get(i).x;
                int y = cur.get(i).y;
                int direct = cur.get(i).direct;

                if (x==destination[0]&&y==destination[1]&&direct==0){
                    return true;
                }

                if (direct == 0) {
                    if (x + 1 < maze_height && flag[x + 1][y] != 1 && maze[x + 1][y] != 1) {
                        int next_direct = 4;
                        if (x+2 == maze_height || maze[x+2][y] ==1)
                            next_direct = 0;
                        temp.add(new Point(x + 1, y,next_direct));
                        flag[x + 1][y] = 1;
                    }
                    if (x - 1 >= 0 && flag[x - 1][y] != 1 && maze[x - 1][y] != 1) {
                        int next_direct = 3;
                        if (x-1 == 0 || maze[x-2][y]==1)
                            next_direct = 0;
                        temp.add(new Point(x - 1, y,next_direct));
                        flag[x - 1][y] = 1;
                    }

                    //2右
                    if (y + 1 < maze_width && flag[x][y + 1] != 1 && maze[x][y + 1] != 1) {
                        int next_direct = 2;
                        if (y+2 == maze_width ||maze[x][y+2]==1)
                            next_direct = 0;
                        temp.add(new Point(x, y + 1,next_direct));
                        flag[x][y + 1] = 1;
                    }

                    if (y - 1 >= 0 && flag[x][y - 1] != 1 && maze[x][y - 1] != 1) {
                        int next_direct = 1;
                        if (y-1==0||maze[x][y-2]==1)
                            next_direct = 0;
                        temp.add(new Point(x, y - 1,next_direct));
                        flag[x][y - 1] = 1;
                    }
                }

                if (direct == 1){ //1左
                    if (y - 1 >= 0 && flag[x][y - 1] != 1 && maze[x][y - 1] != 1) {
                        int next_direct = 1;
                        if (y-1==0||maze[x][y-2]==1)
                            next_direct = 0;
                        temp.add(new Point(x, y - 1,next_direct));
                        flag[x][y - 1] = 1;
                    }
                }
                if (direct == 2){//2右
                    if (y + 1 < maze_width && flag[x][y + 1] != 1 && maze[x][y + 1] != 1) {
                        int next_direct = 2;
                        if (y+2 == maze_width ||maze[x][y+2]==1)
                            next_direct = 0;
                        temp.add(new Point(x, y + 1,next_direct));
                        flag[x][y + 1] = 1;
                    }
                }
                if (direct == 3){
                    if (x - 1 >= 0 && flag[x - 1][y] != 1 && maze[x - 1][y] != 1) {
                        int next_direct = 3;
                        if (x-1 == 0 || maze[x-2][y]==1)
                            next_direct = 0;
                        temp.add(new Point(x - 1, y,next_direct));
                        flag[x - 1][y] = 1;
                    }
                }
                if (direct == 4){
                    if (x + 1 < maze_height && flag[x + 1][y] != 1 && maze[x + 1][y] != 1) {
                        int next_direct = 4;
                        if (x+2 == maze_height || maze[x+2][y] ==1)
                            next_direct = 0;
                        temp.add(new Point(x + 1, y,next_direct));
                        flag[x + 1][y] = 1;
                    }
                }
            }

            cur.clear();
            cur.addAll(temp);
            temp.clear();
        }
        return false;
    }

    /**
     * problem 546
     * @param boxes
     * @return
     */
    public int removeBoxes(int[] boxes) {
        return -1;
    }
    /**
     * problem 552
     * @param n
     * @return
     * 当缺勤次数少于等于1一次时，A与P等价；所以只需考虑迟到对奖励的影响，然后将所得结果乘以2即可。
     */
    public int checkRecord(int n) {
        if (n==1)
            return 3;

        long tar = 1000_000_007;

        int i = 2;

        long suffix_L = 1; // PL
        long suffix_P = 2; // LP PP
        long suffix_LL = 1; // LL
        long A_suffix_L = 1; // AL
        long A_suffix_AP = 3; // AP PA LA
        long A_suffix_LL = 0; //

        while (i<n){
            i++;
            long temp_suffix_L = suffix_P;
            long temp_suffix_P = suffix_P+suffix_L+suffix_LL;
            long temp_suffix_LL = suffix_L;
            long temp_A_suffix_L = A_suffix_AP;
            long temp_A_suffix_AP = suffix_L+suffix_P+suffix_LL + A_suffix_AP + A_suffix_L + A_suffix_LL;
            long temp_A_suffix_LL = A_suffix_L;

            suffix_L = temp_suffix_L % tar;
            suffix_LL = temp_suffix_LL % tar;
            suffix_P = temp_suffix_P % tar;
            A_suffix_L = temp_A_suffix_L % tar;
            A_suffix_AP = temp_A_suffix_AP % tar;
            A_suffix_LL =temp_A_suffix_LL % tar;
        }

        int sum = (int) ((suffix_L+ suffix_P + suffix_LL+ A_suffix_L + A_suffix_LL + A_suffix_AP) % tar);
        return sum;
    }

    /**
     * problem 668
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int findKthNumber(int m, int n, int k) {
        int sum = 0;
        int point1_x = 1;
        int point1_y = 1;
        int point2_x = 1;
        int point2_y = 1;

        while (point1_x != m || point1_y !=n || point2_x !=m || point2_y != n){
            int count = 0;
            if (m > n){
                count = point2_y - point1_y +1;
                sum += count;
            }
            else {
                count = point1_x - point2_x +1;
                sum += count;
            }

            if (sum >= k) {
                sum -= count;
                break;
            }
            if (point1_x < m)
                point1_x++;
            else
                point1_y++;

            if (point2_y < n)
                point2_y++;
            else
                point2_x++;
        }

        List<Integer> list = new ArrayList<>();
        while (point1_x != point2_x && point1_y != point2_y){
            list.add(point1_x*point1_y);
            point1_x--;
            point1_y++;
        }
        list.add(point2_x*point2_y);
        Collections.sort(list);

        return list.get(k - sum -1);
    }
    @Test
    public void test(){
        int m = 45; int n = 12;
        for (int i=1; i<= m; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = i*j;
                if (temp < 10) {
                    System.out.print("  " + temp+" ");
                }
                else if (temp< 100){
                    System.out.print(" " + temp+" ");
                }
                else if (temp< 1000){
                    System.out.print("" + temp+" ");
                }

            }
            System.out.println();
        }
        System.out.println(findKthNumber(m,n,471));
    }
    /**
     * problem 768
     * @param arr
     * @return
     * 一组数能被分为一块，必须满足这一块中的最大值比后面块的最小值要小
     */
    public int maxChunksToSorted(int[] arr) {
        if (arr.length == 1)
            return 1;

        //从后往前遍历，dp[i]为 当index >=i时，arr的最小值
        int[] dp = new int[arr.length];
        dp[arr.length-1] = arr[arr.length-1];
        for (int i=arr.length-2; i>=0; i--){
            dp[i] = Math.min(arr[i],dp[i+1]);
        }

        int max = Integer.MIN_VALUE;
        int count =0 ;
        for (int i=0; i< arr.length-1; i++){
            if (max<arr[i])
                max = arr[i];
            if (max <= dp[i+1]){   //当 当前的最大值，比之后的最小值要小时，count++;
                count++;
                max = Integer.MIN_VALUE;
            }
        }
        count++;
        return count;
    }
    /**
     * problem 903
     * @param S
     * @return
     */
    public int numPermsDISequence(String S) {
            int MOD = 1_000_000_007;
            int N = S.length();

            // dp[i][j] : Num ways to place P_i with relative rank j
            int[][] dp = new int[N+1][N+1];
            Arrays.fill(dp[0], 1);

            for (int i = 1; i <= N; ++i) {
                for (int j = 0; j <= i; ++j) {
                    if (S.charAt(i-1) == 'D') {
                        for (int k = j; k < i; ++k) {
                            dp[i][j] += dp[i-1][k];
                            dp[i][j] %= MOD;
                        }
                    } else {
                        for (int k = 0; k < j; ++k) {
                            dp[i][j] += dp[i-1][k];
                            dp[i][j] %= MOD;
                        }
                    }
                }
            }

            int ans = 0;
            for (int x: dp[N]) {
                ans += x;
                ans %= MOD;
            }

            return ans;
    }
    /**
     * 弹性插入  problem 1029
     * @param costs
     * @return
     */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]-o1[1])-(o2[0]-o2[1]);
            }
        });
        int sum=0;
        int length = costs.length;
        int i =0;
        for (;i<=length/2-1;i++){
            System.out.println(costs[i][0]+" "+costs[i][1]);
            sum=sum+costs[i][0];
        }
        for (;i<length;i++){
            System.out.println(costs[i][1]);
            sum=sum+costs[i][1];
        }
        return sum;
    }

    /**
     * problem 1030
     */
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            container[] containers =new container[R*C];
            int order=0;
            for (int i=0 ;i<R;i++){
                for (int j=0;j<C;j++){
                    containers[order] = new LeetCodeSolution().new container();
                    containers[order].x=i;
                    containers[order].y=j;
                    containers[order].distance = Math.abs(i-r0)+Math.abs(j-c0);
                    order++;
                }
            }
            Arrays.sort(containers);
            int[][] result =new int[R*C][2];
            int index=0;
            for (container container:containers){
                result[index][0]=container.x;
                result[index][1]=container.y;
                index++;
            }
            return result;
    }
    class container implements Comparable<container>{
        int x;
        int y;
        int distance;
        @Override
        public int compareTo(container container){
            return this.distance - container.distance;
        }

    }
    /**
     * problem 1031
     */
    public static int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] dp = new int[A.length+1];
        for (int i=1 ;i<dp.length;i++){
            dp[i]= dp[i-1]+A[i-1];
        }
        int max =-1;
        int sum=0;
        for (int i=0; i+L<dp.length;i++){
            for (int j= i+L;j+M<dp.length;j++){
                sum=(dp[i+L]-dp[i]) + (dp[j+M]-dp[j]);
                if (sum>max)
                    max=sum;
            }
            for (int j=0;j+M<i;j++){
                sum=(dp[i+L]-dp[i]) + (dp[j+M]-dp[j]);
                if (sum>max)
                    max=sum;
            }
        }
        return max;
    }
    /**
     * problem 1033
     */
    public int[] numMovesStones(int a, int b, int c) {
        int[] array = new int[]{a,b,c};
        Arrays.sort(array);
        int x = array[1]-array[0]-1;
        int y = array[2]-array[1]-1;
        if (x==0&&y==0)
            return new int[]{0,0};
        else if (x<=1&&y>1)
            return new int[]{1,array[2]-array[0]-2};
        else if (x>1&&y<=1)
            return new int[]{1,array[2]-array[0]-2};
        else if (x<=1&&y<=1)
            return new int[]{1,array[1]-array[0]+array[2]-array[1]-2};
        else
            return new int[]{2,array[1]-array[0]+array[2]-array[1]-2};
    }
    /**
     * problem 1043
     */
    public int maxSumAfterPartitioning(int[] A, int K) {

        return 0;
    }
    /**
     * problem 1044
     */
    public String longestDupSubstring(String S) {

        return null;
    }

    /**
     * problem 1160
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        for (int i=0; i<words.length; i++){
            if (isGrasp(words[i],chars))
                sum += words[i].length();
        }
        return sum;
    }
    public boolean isGrasp(String word, String chars){
        char[] word_chars = word.toCharArray();
        char[] data = chars.toCharArray();

        Arrays.sort(word_chars);
        Arrays.sort(data);
        int index = 0;
        for (int i=0; i< data.length; i++){
            if (index == word_chars.length)
                return true;
            if (data[i] == word_chars[index]){
                index++;
            }
        }

        if (index == word_chars.length)
            return true;
        return false;
    }

    /**
     * problem 1190
     * @param s
     * @return
     */
    public static int index_problem_1190;
    public String reverseParentheses(String s) {
        index_problem_1190 = 0;

        char[] data = s.toCharArray();

        return Solve_Problem_1190(data);
    }
    public String Solve_Problem_1190(char[] data){
        StringBuilder builder = new StringBuilder("");
        for (; index_problem_1190< data.length; index_problem_1190++){
            if (data[index_problem_1190] == '('){
                index_problem_1190++;
                builder.append(Solve_Problem_1190(data));
            }
            else if (data[index_problem_1190] == ')'){
                return Reverse_Problem_1190(builder.toString());
            }
            else {
                builder.append(data[index_problem_1190]);
            }
        }
        return builder.toString();
    }
    public String Reverse_Problem_1190(String s){
        char[] data = s.toCharArray();
        int start = 0;
        int end = data.length - 1;
        while (start<end) {
            swap(data, start, end);
            start++;
            end--;
        }

        return new String(data);
    }
    public void swap(char[] data, int x, int y){
        char temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }
}

class StreamChecker{
    /**
     * problem 1032
     */
    public WordNode root;
    public StreamChecker(String[] words) {
        tempNodes.clear();
        root = new WordNode('$');
        for (String string:words){
            string =string+"$";
            WordNode currentNode =root;
            char[] chars = string.toCharArray();
            int i=0;
            while (i!=chars.length){
                boolean flag=true;
                for (int count = 0; count<currentNode.currentSize;count++){
                    if (currentNode.next[count].val==chars[i])
                    {
                        currentNode=currentNode.next[count];
                        flag=false;
                    }
                }
                if (flag){
                    WordNode temp = new WordNode(chars[i]);
                    currentNode.next[currentNode.currentSize++]=temp;
                    currentNode = currentNode.next[currentNode.currentSize-1];
                }
                i++;
            }
        }
    }

    public boolean canFromRoot(char letter){
        for (int i=0;i<root.currentSize;i++){
            if (root.next[i].val==letter)
                return true;
        }
        return false;
    }
    private HashMap<Integer,WordNode> tempNodes = new HashMap<>();
    private int tempNodesCurrentSize = 0;
    public boolean query(char letter){
        boolean result = false;
        for (Map.Entry<Integer,WordNode> entry:tempNodes.entrySet()){
            if (entry.getValue()!=null)
                result=result|queryLetter(entry.getKey(),letter);
        }
        if (canFromRoot(letter)){
            WordNode tempRoot = root;
            tempNodesCurrentSize++;
            tempNodes.put(tempNodesCurrentSize,tempRoot);
            result=result|queryLetter(tempNodesCurrentSize,letter);
        }
        return result;
    }
    public boolean queryLetter(int index,char letter) {
        boolean found = false;
        int i=0;
        for (;i<tempNodes.get(index).currentSize;i++){
            if (tempNodes.get(index).next[i].val==letter)
            {
                found=true;
                break;
            }
        }
        if (found){
            tempNodes.put(index,tempNodes.get(index).next[i]);
            for (int i1= 0;i1<tempNodes.get(index).currentSize;i1++){
                if (tempNodes.get(index).next[i1].val=='$')
                    return true;
            }
        }
        if (tempNodes.get(index).currentSize==1&&tempNodes.get(index).next[0].val=='$'){
            tempNodes.put(index,null);
        }
        return false;
    }
}

/**
 * problem 146
 * HashMap + LinkedList; HashMap中的Value对象存储 一个节点 和它的前序节点；
 */
class LRUCache {

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    private void addNode(DLinkedNode node) {
        /**
         * Always add the new node right after head.
         */
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node){
        /**
         * Remove an existing node from the linked list.
         */
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DLinkedNode node){
        /**
         * Move certain node in between to the head.
         */
        removeNode(node);
        addNode(node);
    }

    private DLinkedNode popTail() {
        /**
         * Pop the current tail.
         */
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    private Hashtable<Integer, DLinkedNode> cache =
            new Hashtable<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        // head.prev = null;

        tail = new DLinkedNode();
        // tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) return -1;

        // move the accessed node to the head;
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);

        if(node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;

            if(size > capacity) {
                // pop the tail
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            // update the value.
            node.value = value;
            moveToHead(node);
        }
    }
}

/**
 * 结构体类
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class WordNode{
    char val;
    WordNode[] next = new WordNode[26];
    int currentSize = 0;
    public WordNode(char val){
        this.val=val;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
class EncodeString{
    int num;
    String string;
    public EncodeString(int num, String string){
        this.num = num;
        this.string = string;
    }
}
class Point{
    int x;
    int y;
    int direct;   // 1左 2右 3上 4下
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public Point(int x, int y,int direct){
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}