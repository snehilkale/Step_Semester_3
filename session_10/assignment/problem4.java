package assignment;
public class problem4 {

    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0) {
            return 0;
        }

        int leftIndex = findFirstGreaterOrEqual(scores, low);
        int rightIndex = findFirstGreater(scores, high);

        return rightIndex - leftIndex;
    }

    private static int findFirstGreaterOrEqual(int[] scores, int target) {
        int low = 0;
        int high = scores.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static int findFirstGreater(int[] scores, int target) {
        int low = 0;
        int high = scores.length;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        
        int count1 = countInBand(scores, 42, 58);
        System.out.println(count1);

        int count2 = countInBand(scores, 90, 100);
        System.out.println(count2);
    }
}
