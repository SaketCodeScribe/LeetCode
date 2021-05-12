class Solution {
public:
    pair<int,int> Missingindex(vector<vector<char>>& matrix){
        int i, j, m = matrix.size(), n = matrix[0].size();
        
        for(i = 0; i < m; i++){
            for(j = 0; j < n; j++)
                if (matrix[i][j] == '.')
                    return {i,j};
        }
        
        return {-1,-1};
    }
    bool Valid(vector<vector<char>>& matrix, int num, pair<int,int> mv){
        int i, j, m = matrix.size(), n = matrix[0].size(), r, c;
        
        r = mv.first;
        c = mv.second;
        for(i = 0; i < n; i++)
            if (matrix[r][i] == num + '0')
                return false;
        for(i = 0; i < m; i++)
            if (matrix[i][c] == num + '0')
                return false;
        m = 3 * (r / 3);
        n = 3 * (c / 3);
        for(i = m; i < m + 3; i++){
            for(j = n; j < n + 3; j++)
                if (matrix[i][j] == num + '0')
                    return false;
        }
        return true;
    }
    bool SolveSudoku(vector<vector<char>>& board){
        int i;
        pair<int,int> mv = {};
        
        mv = Missingindex(board);
        if (mv.first == -1)
            return true;
        
        for(i = 1; i <= 9; i++){
            if (Valid(board, i, mv)){
                board[mv.first][mv.second] = i + '0';
                if(!SolveSudoku(board))
                    board[mv.first][mv.second] = '.';
                else
                    return true;
            }
        }
        return false;
    }
    void solveSudoku(vector<vector<char>>& board) {
        SolveSudoku(board);
        return;
    }
};