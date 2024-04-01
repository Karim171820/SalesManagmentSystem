import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TripletSum {

    public static List<List<Integer>> findTriplets(int[] nums, int target) {
        List<List<Integer>> triplets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                int currentTarget = target - nums[i];

                while (left < right) {
                    int currentSum = nums[left] + nums[right];
                    if (currentSum == currentTarget) {
                        triplets.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (currentSum < currentTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return triplets;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] nums = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        List<List<Integer>> result = findTriplets(nums, target);
        if (result.isEmpty()) {
            System.out.println("There are no triplets that sum up to " + target);
        } else {
            System.out.println("Triplets that sum up to " + target + ":");
            for (List<Integer> triplet : result) {
                System.out.println(triplet);
            }
        }

        scanner.close();
    }
}
