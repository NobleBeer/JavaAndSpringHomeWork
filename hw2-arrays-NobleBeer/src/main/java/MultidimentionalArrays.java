public class MultidimentionalArrays {
    public static void printTable(int[][] a) {
        for (int[] i: a)
        {
            if (i != null)
            {
                for (int j: i) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void printTableAligned(int[][] a) {
        for (int[] i : a) {
            if (i != null) {
                for (int k : i) {
                    System.out.printf("%7d", k);
                }
            }
            else { System.out.printf("Поправьте"); }
            System.out.println();
        }
    }
}
