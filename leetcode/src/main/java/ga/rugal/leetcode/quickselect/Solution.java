public class Main {

    private void swap(final int[] l, final int a, final int b) {
        final int temp = l[a];
        l[a] = l[b];
        l[b] = temp;
    }

    private int partition(final int[] list, final int left, final int right, final int pivotIndex) {
        final int pivotValue = list[pivotIndex];
        this.swap(list, pivotIndex, right); //Move pivot to the very end
        int store = left;
        for (int i = left; i < right; ++i)
            if (list[i] < pivotValue) // Move element that is smaller than pivot to the left
                this.swap(list, store++, i);
        // Now that store is the element that is the right most one that is smaller than pivot
        this.swap(list, right, store);
        return store;
    }

    private int select(final int[] list, final int left, final int right, int target) {
        if (left == right)
            return list[left];
        // Choose a good pivot index
        int pivot = right;
        pivot = this.partition(list, left, right, pivot);
        if (target == pivot)
            return list[target];
        return target < pivot
                // Keep searching the left part and the target is at the left as well
                ? this.select(list, left, pivot - 1, target)
                // The target is at the right
                // The part after pivot is number of pivot less elements
                : this.select(list, pivot + 1, right, target - pivot);
    }

    public int quickSelect(final int[] list, final int k) {
        return this.select(list, 0, list.length - 1, k);
    }

    public static void main(String[] args) {
        final Main m = new Main();
        final int[] list = new int[]{3, 2, 7, 5, 8, 9};
        final int k = 0;
        System.out.println(m.quickSelect(list, k));
    }
}
