class RecentCounter {
    private Deque<Integer> requests;

    public RecentCounter() {
        requests = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        requests.addLast(t);
        while (requests.peekFirst() < t - 3000) {
            requests.pollFirst();
        }
        return requests.size();
    }
}