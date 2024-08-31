/// OPTIMIZED APPROACH - Time complexity( O (1) )

class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {

        board[rMove][cMove] = color;
        int len;
        char oppositeColor = color == 'B' ? 'W' : 'B';

        int[][] directions = {
                              {-1, -1},
                              {-1, 0},
                              {-1, +1},
                              {0, +1},
                              {+1, +1},
                              {+1, 0},
                              {+1, -1},
                              {0, -1}
                                        };

        for(int dir[] : directions){
            int i = rMove + dir[0];
            int j = cMove + dir[1];
            len = 0;

            while(i >= 0 && j >= 0 && i < 8 && j < 8 && board[i][j] == oppositeColor){
                i += dir[0];
                j += dir[1];
                len++;
            }
            
            if(i >= 0 && j >= 0 && i < 8 && j < 8 && len > 0 && board[i][j] == color){
                return true;
            }
        }

        return false;
    } 
}


// BRUTE FORCE APPROACH
// class Solution {
//     public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
//         boolean _1 = false;
//         boolean _2 = false;
//         boolean _3 = false;
//         boolean _4 = false;
//         boolean _5 = false;
//         boolean _6 = false;
//         boolean _7 = false;
//         boolean _8 = false;
//         int len;
        
//         board[rMove][cMove] = color;
        
//         len = 0;
//         if(rMove != 0 && cMove !=  0){
//             for(int i = rMove, j = cMove;i > 0 && j > 0;i--, j--){
//                 if(board[i-1][j-1] != color && board[i-1][j-1] != '.'){
//                     len++;
//                 }
//                 else if(board[i-1][j-1] == color && len > 0){
//                     _1 = true;
//                     break;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }

//         len = 0;
//         if(rMove != 0){
//             for(int i = rMove, j = cMove;i > 0;i--){
//                 if(board[i-1][j] != color && board[i-1][j] != '.'){
//                     len++;
//                 }
//                 else if(board[i-1][j] == color && len > 0){
//                     _2 = true;
//                     break;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }

//         len = 0;
//         if(rMove != 0 && cMove != 7){
//             for(int i = rMove, j = cMove;i > 0 && j < 7;i--, j++){
//                 if(board[i-1][j+1] != color && board[i-1][j+1] != '.'){
//                     len++;
//                 }
//                 else if(board[i-1][j+1] == color && len > 0){
//                     _3 = true;
//                     break;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }

//         len = 0;
//         if(cMove != 7){
//             for(int i = rMove, j = cMove; j < 7; j++){
//                 if(board[i][j+1] != color && board[i][j+1] != '.'){
//                     len++;
//                 }
//                 else if(board[i][j+1] == color && len > 0){
//                     _4 = true;
//                     break;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }

//         len = 0;
//         if(rMove != 7 && cMove != 7){
//             for(int i = rMove, j = cMove;i < 7 && j < 7;i++, j++){
//                 if(board[i+1][j+1] != color && board[i+1][j+1] != '.'){
//                     len++;
//                 }
//                 else if(board[i+1][j+1] == color && len > 0){
//                     _5 = true;
//                     break;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }

//         len = 0;
//         if(rMove != 7){
//             for(int i = rMove, j = cMove;i < 7;i++){
//                 if(board[i+1][j] != color && board[i+1][j] != '.'){
//                     len++;
//                 }
//                 else if(board[i+1][j] == color && len > 0){
//                     _6 = true;
//                     break;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }

//         len = 0;
//         if(rMove != 7 && cMove != 0){
//             for(int i = rMove, j = cMove;i < 7 && j > 0;i++, j--){
//                 if(board[i+1][j-1] != color && board[i+1][j-1] != '.'){
//                     len++;
//                 }
//                 else if(board[i+1][j-1] == color && len > 0){
//                     _7 = true;
//                     break;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }

//         len = 0;
//         if(cMove != 0){
//             for(int i = rMove, j = cMove;j > 0; j--){
//                 if(board[i][j-1] != color && board[i][j-1] != '.'){
//                     len++;
//                 }
//                 else if(board[i][j-1] == color && len > 0){
//                     _8 = true;
//                     break;
//                 }
//                 else{
//                     break;
//                 }
//             }
//         }

//         return _1 || _2 || _3 || _4 || _5 || _6 || _7 || _8;
//     }
// }
