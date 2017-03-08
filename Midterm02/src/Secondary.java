/**
 * Created by Jimin on 3/7/17.
 */
public class Secondary {
    int[][] secondary;
    int[][] M;
    int[][] path;
    int[] RowCover;
    int[] ColCover;
    int path_row_0;
    int path_col_0;
    int path_count;
    int size;

    public Secondary(int[][] secondary, int size) {
        this.secondary = secondary;
        M = new int[size][size];
        path = new int[size][size];
        RowCover = new int[size];
        ColCover = new int[size];
        this.size = size;

        for(int r=0; r< size; r++) {
            RowCover[r]=0;
            ColCover[r] = 0;
            for(int c=0; c< size; c++){
                M[r][c] = 0;
            }
        }
    }

    public int[][] getM(){
        return M;
    }



    public void find() {
        boolean done = false;
        int step=1;
        while(!done) {
            switch (step) {
                case 1:
                    step = step_one();
                    break;
                case 2:
                    step = step_two();
                    break;
                case 3:
                    step = step_three();
                    break;
                case 4:
                    step = step_four();
                    break;
//                case 5:
//                    step = step_five();
//                    break;
                case 6:
                    step = step_six();
                    break;
                case 7:
                    done = true;
                    break;

            }
        }
    }
    private int step_one(){
        int min_in_row;

        for(int r=0; r< size; r++) {
            min_in_row = secondary[r][0];
            for(int c=0; c< size; c++){
                if(secondary[r][c] < min_in_row) {
                    min_in_row = secondary[r][c];
                }
            }
            for(int c=0; c< size; c++){
                secondary[r][c] -= min_in_row;
            }
        }
        return 2;
    }

    private int step_two() {
        for(int i=0; i<size; i++) {
            RowCover[i] = 0;
            ColCover[i]=0;
        }
        for(int r=0; r<size; r++) {
            for(int c=0; c<size; c++) {
                if (secondary[r][c] == 0 && RowCover[r] == 0 && ColCover[c] == 0) {
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

        for(int r=0; r<size; r++) {
            for (int c = 0; c < size; c++) {
                if (M[r][c] == 1) {
                    ColCover[c] = 1;
                }
            }
        }
        colcount = 0;

        for (int c = 0; c < size; c++) {
            if (ColCover[c] == 1) {
                colcount += 1;
            }
        }

        if(colcount >= size) {
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

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
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
        for(int c=0; c<size; c++){
            if(M[row][c] == 2)
                tmp = true;
        }
        return tmp;
    }

    private int find_star_in_row(int row, int col) {
        col = -1;
        for(int c =0; c< size; c++) {
            if(M[row][c] == 2) {
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
        for(int i=0; i<size; i++) {
            if(M[i][c] == 1)
                r=i;
        }
        return r;
    }

    public int find_prime_in_row(int r, int c){
        for(int j=0; j<size; j++) {
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
        for(int r=0; r<size; r++) {
            RowCover[r] = 0;
            ColCover[r] = 0;
        }
    }

    public void erase_primes() {
        for(int r=0; r<size; r++) {
            for(int c=0; c<size; c++) {
                if(M[r][c] == 2)
                    M[r][c] = 0;
            }
        }
    }

    private int step_six() {
        int minval = Integer.MAX_VALUE;
        int count=0;
        minval = find_smallest(minval);
        for(int r=0; r<size; r++) {
            for(int c=0; c<size ;c++) {
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

        if(count >=size) {
            return 3;
        }
        return 4;
    }

    private int find_smallest(int minval){
        for(int r=0; r<size; r++) {
            for(int c=0; c<size ;c++) {
                if(RowCover[r] == 0 && ColCover[c] == 0){
                    if(minval > secondary[r][c]){
                        minval = secondary[r][c];
                    }
                }
            }
        }
        return minval;
    }
}
