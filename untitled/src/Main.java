public static List<Integer> getMax(List<String> operations)
{
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxstack = new Stack<>();
    List<Integer> list=new ArrayList<>();
    for(String item:operations)
    {
        String[] parts = item.split(" ");
        if(parts[0].equals("1"))
        {
            int value=Integer.parseInt(parts[1]);
            stack.push(value);
            if(maxstack.isEmpty() || value>maxstack.peek())
            {
                maxstack.push(value);
            }
            else
            {
                maxstack.push(maxstack.peek());
            }
        }
        else if(parts[0].equals("2"))
        {
            stack.pop();
            maxstack.pop();


        }
        else if(parts[0].equals("3"))
        {
            list.add(maxstack.peek());

        }

    }
    return list;
}


}

//***************************************************************************************************************************


public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3)
{
    int sum1 =sum(h1);
    int sum2 =sum(h2);
    int sum3 =sum(h3);



    Stack<Integer> stack1  = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    Stack<Integer> stack3 = new Stack<>();

    tostack(h1,stack1);
    tostack(h2,stack2);
    tostack(h3,stack3);

    while(true)
    {

        if(sum1==sum2 && sum1==sum3)
        {
            return sum1;

        }

        int max2=Math.max(sum2,sum3);
        int max = Math.max(sum1,max2);

        if(max==sum1)
        {
            sum1=sum1-stack1.pop();
        }
        if(max==sum2)
        {
            sum2=sum2-stack2.pop();
        }
        if(max==sum3)
        {
            sum3=sum3-stack3.pop();
        }
    }
}

static int sum(List<Integer> sum)
{
    int length=sum.size();
    int summ=0;
    for(int i=0;i<length;i++)
    {
        summ=summ+sum.get(i);
    }
    return summ;


}


static void tostack(List<Integer> liste,Stack<Integer> stack)
{

    int length2=liste.size();
    for(int i=length2-1;i>=0;i--)
    {
        stack.push(liste.get(i));

    }

}


}
