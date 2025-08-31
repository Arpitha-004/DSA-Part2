class MinStack {
    Stack<Long> st = new Stack<>();
    Long min;

    public MinStack() {
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long v = Long.valueOf(val);
        if(st.isEmpty()){
            min = v;
            st.push(v);
        }else{
            if(val<min){
                st.push(2*v-min);
                min=v;  
            }else{
                st.push(v);
            }   
        }
    }
    
    public void pop() {
        if(st.isEmpty())
            return;
        Long val = st.pop();
        if(val<min){
            min=2*min-val;
        }
    }
    
    public int top() {
        Long val = st.peek();
        if(val<min){
            return min.intValue();
        }
        return val.intValue();
    }
    
    public int getMin() {
        return min.intValue();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */