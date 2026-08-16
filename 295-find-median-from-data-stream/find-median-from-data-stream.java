class MedianFinder {

    PriorityQueue<Integer> left =
        new PriorityQueue<>((a, b) -> b - a);

    PriorityQueue<Integer> right =
        new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {

        left.offer(num);

        // If the biggest number in left is bigger
        // than the smallest number in right,
        // move it to right.
        if (!right.isEmpty() && left.peek() > right.peek()) {
            right.offer(left.poll());
        }

        // Keep left from being more than 1 element
        // larger than right.
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        }

        // If right becomes larger, move its smallest
        // element to left.
        if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}