class Solution {
    public void sortColors(int[] nums) {
        int x, y, z, i;
        x = y = z = 0;

        for (i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                x++;
            else if (nums[i] == 1)
                y++;
            else
                z++;
        }

        i = 0;

        while (x > 0) {
            nums[i] = 0;
            x--;
            i++;
        }

        while (y > 0) {
            nums[i] = 1;
            y--;       // FIXED
            i++;
        }

        while (z > 0) {
            nums[i] = 2;
            z--;
            i++;
        }
    }
}