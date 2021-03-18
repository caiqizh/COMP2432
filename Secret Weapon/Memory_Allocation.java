class Memory_Allocation {
    // Method to allocate memory to
    // blocks as per First fit algorithm
    static void firstFit(int sum, int blockSize[], int m,
                         int processSize[], int n)
    {
        // Stores block id of the
        // block allocated to a process
        int allocation[] = new int[n];

        int sumofholes =0;

        for (int i = 0; i < m; i++) {
            sumofholes += blockSize[i];
        }
        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (blockSize[j] >= processSize[i])
                {
                    // allocate block j to p[i] process
                    allocation[i] = j;

                    // Reduce available memory in this block.
                    blockSize[j] -= processSize[i];

                    break;
                }
            }
        }
        System.out.println("This is first fit algorithm: \n ");
        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++)
        {
            System.out.print(" " + (i+1) + "\t\t" +
                    processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }

        double r;
        double a;
        int usage =0;


        for (int i = 0; i < n; i++) {
            if(allocation[i] != -1){
                usage += processSize[i];
            }
        }
        a = (sum - sumofholes + usage);
        r = a / sum;
        System.out.println(r);
    }


    static void bestFit(int sum, int blockSize[], int m, int processSize[],
                        int n) {
        // Stores block id of the block allocated to a
        // process
        int allocation[] = new int[n];

        int sumofholes =0;

        for (int i = 0; i < m; i++) {
            sumofholes += blockSize[i];
        }

        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++) {
            // Find the best fit block for current process
            int bestIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (bestIdx == -1)
                        bestIdx = j;
                    else if (blockSize[bestIdx] > blockSize[j])
                        bestIdx = j;
                }
            }

            // If we could find a block for current process
            if (bestIdx != -1) {
                // allocate block j to p[i] process
                allocation[i] = bestIdx;

                // Reduce available memory in this block.
                blockSize[bestIdx] -= processSize[i];
            }
        }
        System.out.println("This is best fit algorithm: \n ");

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print("   " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }
        double r;
        double a;
        int usage =0;


        for (int i = 0; i < n; i++) {
            if(allocation[i] != -1){
                usage += processSize[i];
            }
        }
        a = (sum - sumofholes + usage);
        r = a / sum;
        System.out.println(r);
    }

    static void worstFit(int sum, int blockSize[], int m, int processSize[],
                         int n) {
        // Stores block id of the block allocated to a
        // process
        int allocation[] = new int[n];


        int sumofholes =0;

        for (int i = 0; i < m; i++) {
            sumofholes += blockSize[i];
        }
        // Initially no block is assigned to any process
        for (int i = 0; i < allocation.length; i++)
            allocation[i] = -1;

        // pick each process and find suitable blocks
        // according to its size ad assign to it
        for (int i = 0; i < n; i++) {
            // Find the best fit block for current process
            int wstIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (wstIdx == -1)
                        wstIdx = j;
                    else if (blockSize[wstIdx] < blockSize[j])
                        wstIdx = j;
                }
            }

            // If we could find a block for current process
            if (wstIdx != -1) {
                // allocate block j to p[i] process
                allocation[i] = wstIdx;

                // Reduce available memory in this block.
                blockSize[wstIdx] -= processSize[i];
            }
        }

        System.out.println("\nProcess No.\tProcess Size\tBlock no.");
        for (int i = 0; i < n; i++) {
            System.out.print("   " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            System.out.println();
        }

        double r;
        double a;
        int usage =0;


        for (int i = 0; i < n; i++) {
            if(allocation[i] != -1){
                usage += processSize[i];
            }
        }
        a = (sum - sumofholes + usage);
        r = a / sum;
        System.out.println(r);
    }
        // Driver Code
    public static void main(String[] args)
    {
        int sum = 700;
        int blockSize[] = {60,90,80};
        int processSize[] = {36, 48, 42, 33, 21, 29};
        int m = blockSize.length;
        int n = processSize.length;
        int[] blockSize1 = new int[m];
        int[] blockSize2= new int[m];
        int[] processSize1 = new int [n];
        int[] processSize2 = new int [n];
        for (int i = 0; i < m; i++) {
            blockSize1[i] = blockSize[i];
            blockSize2[i] = blockSize[i];
        }
        for (int i = 0; i < n; i++) {
            processSize1[i] = processSize[i];
            processSize2[i] = processSize[i];

        }

        firstFit(sum, blockSize, m, processSize, n);
        bestFit(sum,blockSize1, m, processSize1, n);
        worstFit(sum, blockSize2, m, processSize2, n);
    }
}