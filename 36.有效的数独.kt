/**
 * 36.有效的数独
 *
 * 查重时可以采用Set集合或是用in关键字的方法
 * Array可以用nums[i]的形式访问，Array<Array>可以用nums[i][j]的形式访问
 * 遍历二位数组时，一趟遍历可以访问一整列或是一整排
 */
fun isValidSudoku(board: Array<CharArray>): Boolean {//近似于暴力破解
    val row=HashSet<Char>()
    val col=HashSet<Char>()
    val night=HashSet<Char>()
    for(i in 0..board.size-1){
        for(j in 0..board.size-1){
            //行
            if('.'!=board[i][j]){
                if(!row.add(board[i][j])){
                    return false
                }
            }
            //列
            if('.'!=board[j][i]){//调换i，j顺序遍历列
                if(!col.add(board[j][i])){
                    return false
                }
            }
            //九宫格
            if('.'!=board[j/3+i/3*3][i%3*3+j%3]){//这块的下标才是精髓
                if(!night.add(board[j/3+i/3*3][i%3*3+j%3])){
                    return false
                }
            }
        }
        row.clear()
        col.clear()
        night.clear()
    }
    return true
}