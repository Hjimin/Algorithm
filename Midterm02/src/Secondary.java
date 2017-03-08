/**
 * Created by Jimin on 3/7/17.
 */
public class Secondary {
    int[][] secondary;
    int[][] M = new int[9][9];
    int[][] path = new int[9][9];
    int[] RowCover = new int[9];
    int[] ColCover = new int[9];
    int path_row_0;
    int path_col_0;
    int path_count;

    public Secondary(int[][] secondary) {
        this.secondary = secondary;

        for(int r=0; r< 9; r++) {
            RowCover[r]=0;
            ColCover[r] = 0;
            for(int c=0; c< 9; c++){
                M[r][c] = 0;
            }
        }
    }

//    public void find() {
//        for(int r=0; r< 9; r++) {
//            for(int c=0; c< 9; c++){
//                System.out.print(secondary[r][c]+" ");
//            }
//            System.out.println(" ");
//        }
//
//        System.out.println("  \n\n");
//
//        step_one();
//        for(int r=0; r< 9; r++) {
//            for(int c=0; c< 9; c++){
//                System.out.print(secondary[r][c] + " ");
//            }
//            System.out.println(" ");
//        }
//
//        System.out.println("  \n\n");
//        step_two();
//         for(int r=0; r< 9; r++) {
//             for (int c = 0; c < 9; c++) {
//                 System.out.print(M[r][c] + " ");
//             }
//             System.out.println(" ");
//         }
//        System.out.println("  \n\n");
//        System.out.println(step_three());
//
//        step_four();
//    }

    public void find() {
        boolean done = false;
        int step=1;
        while(!done) {
            switch (step) {
                case 1:
                    System.out.println("step 1");
                    step = step_one();
                    break;
                case 2:
                    System.out.println("step 2");
                    step = step_two();

                    break;
                case 3:
//                    System.out.println("step 3");
                    step = step_three();
                    break;
                case 4:
//                    System.out.println("step 4");
                    step = step_four();
//                    for(int r=0; r< 9; r++) {
////                        System.out.println(ColCover[r]);
//                         for (int c = 0; c < 9; c++) {
//                             System.out.print(secondary[r][c] + " ");
////                             System.out.print(M[r][c] + " ");
//                         }
//                         System.out.println(" ");
//                     }
                    break;
//                case 5:
////                    System.out.println("step 5");
//                    step = step_five();
//                    break;
                case 6:
//                    System.out.println("step 6");
                    step = step_six();
//                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&");
//                    for(int r=0; r< 9; r++) {
//////                        System.out.println(ColCover[r]);
//                         for (int c = 0; c < 9; c++) {
//                             System.out.print(M[r][c] + " ");
////                             System.out.print(M[r][c] + " ");
//                         }
//                         System.out.println(" ");
//                     }
                    break;
                case 7:
                    System.out.println("step 7");
                    done = true;
                    break;

            }
        }
    }
    private int step_one(){
        int min_in_row;

        for(int r=0; r< 9; r++) {
            min_in_row = secondary[r][0];
            for(int c=0; c< 9; c++){
                if(secondary[r][c] < min_in_row) {
                    min_in_row = secondary[r][c];
                }
            }
            for(int c=0; c< 9; c++){
                secondary[r][c] -= min_in_row;
            }
        }
        return 2;
    }

    private int step_two() {
        for(int i=0; i<9; i++) {
            RowCover[i] = 0;
            ColCover[i]=0;
        }
        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++) {
                if (secondary[r][c] == 0 && RowCover[r] == 0 && ColCover[c] == 0) {
//                    System.out.println("haha");
                    M[r][c] = 1;
                    RowCover[r] = 1;
                    ColCover[c] = 1;
                }
            }
        }


        return 3;
    }

    private int step_three(){
        int colcount;

        for(int r=0; r<9; r++) {
            for (int c = 0; c < 9; c++) {
                if (M[r][c] == 1) {
                    ColCover[c] = 1;
                }
            }
        }
        colcount = 0;

        for (int c = 0; c < 9; c++) {
            if (ColCover[c] == 1) {
                colcount += 1;
            }
        }

//        System.out.println("colcount " + colcount);
        if(colcount >= 9) {
            return 7;
        } else {
            return 4;
        }
    }
        private int step_four() {
        int[] tmp;
        int row = -1;
        int col = -1;
        boolean done;
        int step = 4;

        done = false;
        while (!done){
            tmp = find_a_zero();
            row = tmp[0];
            col = tmp[1];
//            System.out.println("row"+row);
//            System.out.println("col"+col);

            if(row == -1) {
                done = true;
                step= 6;
            } else {
                M[row][col] = 2;
                if(star_in_row(row)) {
                    col = find_star_in_row(row, col);
                    RowCover[row] = 1;
                    ColCover[col] = 0;
                } else {
                    System.out.println("haha");
                    done = true;
                    step = 5;
                    path_row_0 = row;
                    path_col_0 = col;
                }
            }
        }
        return step;
    }

    private int[] find_a_zero() {
        int[] ret = new int[2];
        int row = -1;
        int col = -1;

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
//                System.out.println(secondary[r][c] +" " + RowCover[r] +" "+ ColCover[c] + " ");
                if (secondary[r][c] == 0 && RowCover[r] == 0 && ColCover[c] == 0) {
                    row = r;
                    col = c;
                    break;
                }
            }
//            System.out.println(" ");
        }
        ret[0] = row;
        ret[1] = col;
        return ret;
    }

//
    private boolean star_in_row(int row){
        boolean tmp = false;
        for(int c=0; c<9; c++){
            if(M[row][c] == 2)
                tmp = true;
        }
        return tmp;
    }

    private int find_star_in_row(int row, int col) {
        col = -1;
        for(int c =0; c< 9; c++) {
            if(M[row][c] == 2) {
                System.out.println("ddddddddddddddddd");
                M[row][c] =1;
                col = c;
            }
        }
        return col;
    }


    private int step_five() {
        boolean done;
        int r = -1;
        int c = -1;

        path_count = 1;
        path[path_count-1][0] = path_row_0;
        path[path_count-1][1] = path_col_0;

        done = false;

        while(!done) {
            r = find_star_in_col(path[path_count-1][1], r);
            if(r > -1) {
                path_count += 1;
                path[path_count-1][0] = r;
                path[path_count-1][1] = path[path_count - 2][1];
            } else {
                done = true;
            }

            if(!done) {
                c = find_prime_in_row(path[path_count - 1][0], c);
                path_count += 1;
                path[path_count -1][0] = path[path_count -2][0];
                path[path_count-1][1] = c;
            }
        }

        augment_path();
        clear_covers();
        erase_primes();
        return 3;

    }

    public int find_star_in_col(int c, int r) {
        r = -1;
        for(int i=0; i<9; i++) {
            if(M[i][c] == 1)
                r=i;
        }
        return r;
    }

    public int find_prime_in_row(int r, int c){
        for(int j=0; j<9; j++) {
            if(M[r][j] == 2)
                c = j;
        }
        return c;
    }

    public void augment_path(){
        for(int p=0; p<path_count; p++){
            if(M[path[p][0]][path[p][1]] == 1) {
                M[path[p][0]][path[p][1]] = 0;
            } else {
                M[path[p][0]][path[p][1]] = 0;
            }
        }
    }

    public void clear_covers() {
        for(int r=0; r<9; r++) {
            RowCover[r] = 0;
            ColCover[r] = 0;
        }
    }

    public void erase_primes() {
        for(int r=0; r<9; r++) {
            for(int c=0; c<9; c++) {
                if(M[r][c] == 2)
                    M[r][c] = 0;
            }
        }
    }

    private int step_six() {
        int minval = Integer.MAX_VALUE;
        int count=0;
        minval = find_smallest(minval);
        for(int r=0; r<9; r++) {
            for(int c=0; c<9 ;c++) {
                if(RowCover[r] == 1){
                    secondary[r][c] += minval;
                }
                if (ColCover[c] == 0){
                    secondary[r][c] -= minval;
                } else if(ColCover[c] == 1){
                    count++;
                }
            }
        }

        if(count >=9) {
            return 3;
        }
        return 4;
    }

    private int find_smallest(int minval){
        for(int r=0; r<9; r++) {
            for(int c=0; c<9 ;c++) {
                if(RowCover[r] == 0 && ColCover[c] == 0){
                    if(minval > secondary[r][c]){
                        minval = secondary[r][c];
                        System.out.println("r "+r+ " c " + c +" "+minval);
                    }
                }
            }
        }
        return minval;
    }
}
//private int[] find_a_zero(){
//        int[] ret = new int[2];
////        int r=0;
////        int c;
////        boolean done;
//        int row = -1;
//        int col = -1;
////        done = false;
//
//
//       for(int r=0; r< 9; r++) {
//           for (int c = 0; c < 9; c++) {
//               if(secondary[r][c] == 0 && RowCover[r]==0 && ColCover[c]==0) {
//                    row = r;
//                    col = c;
//                   break;
//                }
//           }
//           System.out.println(" ");
//       }
////        while(!done) {
////            c =0;
////            while(true) {
//////                for(int i=0; i< 9; i++) {
//////                    for(int j=0; j< 9; j++){
//////                        System.out.print(secondary[i][j] + " ");
//////                    }
//////                    System.out.println(" ");
//////                }
////
////                if(secondary[r][c] == 0 && RowCover[r]==0 && ColCover[c]==0) {
////                    row = r;
////                    col = c;
////                    done = true;
////                }
////
////                c+=1;
////                if(c>=9 || done)
////                    break;
////            }
////            r +=1;
////            if(r >= 9)
////                done = true;
////        }
//        ret[0] = row;
//        ret[1] = col;
//        return ret;
//    }
