package teme.w01_intro;

class Ex11_KnightMoves {

    /**
     * Check if a given position is valid (within the bounds of a 8x8 chess table)
     *
     * @param row row number (valid range: 1..8)
     * @param col column number (valid range: 1..8)
     * @return true if both row and col values are in valid range, false otherwise
     */
    static boolean isValidPos(int row, int col) {
        return (row >= 1 && row <= 8) && (col >= 1 && col <= 8);
    }

    /**
     * Starting from a current position (row+column) and a given piece movement on table
     * (specified as a number of rows to move, and a number of columns, relative to current pos)
     * it will compute and return the destination position, encoded as a single String value.
     * <p>
     * If either the current or the destination position are invalid (outside the table)
     * it will return instead just an empty string.
     *
     * @param crtRow     current row (valid range: 1..8)
     * @param crtCol     current column (valid range: 1..8)
     * @param rowsToMove number of rows to move (a positive or negative number)
     * @param colsToMove number of rows to move (a positive or negative number)
     * @return the destination position as a string with format "(row,col)",
     * or empty string if source or destination positions are invalid
     */
    static String getDestinationIfValid(int crtRow, int crtCol,
                                        int rowsToMove, int colsToMove) {
        int row = crtRow + rowsToMove;
        int col = crtCol + colsToMove;
        String result = String.format("(%d,%d)", row, col);
        //hint: may call here isValidPos() as needed..
        return isValidPos(crtRow, crtCol) && validRowsToMove(crtRow, rowsToMove) && validColsToMove(crtCol, colsToMove) ? result : "";
    }

    static boolean validRowsToMove(int crtRow, int rowsToMove) {
        int row = crtRow + rowsToMove;
        return row >= 1 && row <= 8;
    }

    static boolean validColsToMove(int crtCol, int colsToMove) {
        int col = crtCol + colsToMove;
        return col >= 1 && col <= 8;
    }


    /**
     * Given the current position of a knight (row+column), it will compute and return
     * the list of all VALID possible destinations to reach in 1 valid knight move.
     *
     * @param crtRow current row
     * @param crtCol current column
     * @return list of all valid destinations, in format "(row1,col1)(row2,col2)...(rowN,colN)"
     * (the order of destination cells doesn't count)
     */
    static String getAllValidDestinations(int crtRow, int crtCol) {
        return isValidPos(crtRow, crtCol) ? (validRow1Col3(crtRow, crtCol) + validRow1Col4(crtRow, crtCol) + validRow2Col3(crtRow, crtCol) + validRow2Col4(crtRow, crtCol) + validRow3Col1(crtRow, crtCol) + validRow3Col2(crtRow, crtCol) + validRow4Col1(crtRow, crtCol) + validRow4Col2(crtRow, crtCol)) : ("");
    }

    static boolean validRow1(int crtRow) {
        int row1 = crtRow + 1;
        return row1 >= 1 && row1 <= 8;
    }

    static boolean validRow2(int crtRow) {
        int row2 = crtRow - 1;
        return row2 >= 1 && row2 <= 8;
    }

    static boolean validRow3(int crtRow) {
        int row3 = crtRow + 2;
        return row3 >= 1 && row3 <= 8;
    }

    static boolean validRow4(int crtRow) {
        int row4 = crtRow - 2;
        return row4 >= 1 && row4 <= 8;
    }

    static boolean validCol1(int crtCol) {
        int col1 = crtCol + 1;
        return col1 >= 1 && col1 <= 8;
    }

    static boolean validCol2(int crtCol) {
        int col2 = crtCol - 1;
        return col2 >= 1 && col2 <= 8;
    }

    static boolean validCol3(int crtCol) {
        int col3 = crtCol + 2;
        return col3 >= 1 && col3 <= 8;
    }

    static boolean validCol4(int crtCol) {
        int col4 = crtCol - 2;
        return col4 >= 1 && col4 <= 8;
    }

    static String validRow1Col3(int crtRow, int crtCol) {
        int row1 = crtRow + 1;
        int col3 = crtCol + 2;
        String result13 = String.format("(%d,%d)", row1, col3);
        return validRow1(crtRow) && validCol3(crtCol) ? result13 : "";
    }

    static String validRow1Col4(int crtRow, int crtCol) {
        int row1 = crtRow + 1;
        int col4 = crtCol - 2;
        String result14 = String.format("(%d,%d)", row1, col4);
        return validRow1(crtRow) && validCol4(crtCol) ? result14 : "";
    }

    static String validRow2Col3(int crtRow, int crtCol) {
        int row2 = crtRow - 1;
        int col3 = crtCol + 2;
        String result23 = String.format("(%d,%d)", row2, col3);
        return validRow2(crtRow) && validCol3(crtCol) ? result23 : "";
    }

    static String validRow2Col4(int crtRow, int crtCol) {
        int row2 = crtRow - 1;
        int col4 = crtCol - 2;
        String result24 = String.format("(%d,%d)", row2, col4);
        return validRow2(crtRow) && validCol4(crtCol) ? result24 : "";
    }

    static String validRow3Col1(int crtRow, int crtCol) {
        int row3 = crtRow + 2;
        int col1 = crtCol + 1;
        String result31 = String.format("(%d,%d)", row3, col1);
        return validRow3(crtRow) && validCol1(crtCol) ? result31 : "";
    }

    static String validRow3Col2(int crtRow, int crtCol) {
        int row3 = crtRow + 2;
        int col2 = crtCol - 1;
        String result32 = String.format("(%d,%d)", row3, col2);
        return validRow3(crtRow) && validCol2(crtCol) ? result32 : "";
    }

    static String validRow4Col1(int crtRow, int crtCol) {
        int row4 = crtRow - 2;
        int col1 = crtCol + 1;
        String result41 = String.format("(%d,%d)", row4, col1);
        return validRow4(crtRow) && validCol1(crtCol) ? result41 : "";
    }

    static String validRow4Col2(int crtRow, int crtCol) {
        int row4 = crtRow - 2;
        int col2 = crtCol - 1;
        String result42 = String.format("(%d,%d)", row4, col2);
        return validRow4(crtRow) && validCol2(crtCol) ? result42 : "";
    }

    /**
     * Main, just for running manual tests
     */
    public static void main(String[] args) {
        System.out.println(isValidPos(1, 9));
        System.out.println(isValidPos(2, 4));

        System.out.println(getDestinationIfValid(1, 1, -2, +1));
        System.out.println(getDestinationIfValid(1, 1, +2, +1));

        System.out.println(getAllValidDestinations(1, 1));
        System.out.println(getAllValidDestinations(2, 4));
    }
}
