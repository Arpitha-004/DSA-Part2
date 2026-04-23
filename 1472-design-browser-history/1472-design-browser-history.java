class BrowserHistory {
    Stack<String> s1 = new Stack<>();
    Stack<String> s2 = new Stack<>();
    String homepage;
    public BrowserHistory(String homepage) {
        this.homepage = homepage;
        s1.push(homepage);
    }
    
    public void visit(String url) {
        s1.push(url);
        s2.clear();
    }
    
    public String back(int steps) {
        while(steps > 0 && s1.size() > 1){
            s2.push(s1.pop());
            steps--;
        }
        return s1.peek();
    }
    
    public String forward(int steps) {
        while(steps > 0 && s2.size() > 0){
            s1.push(s2.pop());
            steps--;
        }
        return s1.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */