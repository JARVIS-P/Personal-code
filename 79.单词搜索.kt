fun main() {
    //println(exist(arrayOf(charArrayOf('A','B','C','E'),charArrayOf('S','F','E','S'), charArrayOf('A','D','E','E')),"ABC"))
    println("Asd")
}

var flag=false

/*fun exist(board: Array<CharArray>, word: String): Boolean {
    val iList= arrayListOf<Int>()
    val jList= arrayListOf<Int>()

    for(i in 0 until board.size){
        for(j in 0 until board[0].size){
            if(board[i][j]==word[0]){
                iList.add(i)
                jList.add(j)
            }
        }
    }

    if(iList.isEmpty()){
        return false
    }

    for(i in 0 until iList.size){
        dfs(iList[i],jList[i],board,word,1)
    }

    return flag
}

fun dfs(i: Int, j: Int, board: Array<CharArray>, word: String, cur: Int){
    if(cur==word.length){
        flag=true
    }else {
        if(i!=0){
            if(board[i-1][j]==word[cur]){
                board[i][j]=' '
                dfs(i-1,j,board,word,cur+1)
            }
        }

        if(i!=board.size-1){
            if(board[i+1][j]==word[cur]){
                board[i][j]=' '
                dfs(i+1,j,board,word,cur+1)
            }
        }

        if(j!=0){
            if(board[i][j-1]==word[cur]){
                board[i][j]=' '
                dfs(i,j-1,board,word,cur+1)
            }
        }

        if(j!=board[0].size-1){
            if(board[i][j+1]==word[cur]){
                board[i][j]=' '
                dfs(i,j+1,board,word,cur+1)
            }
        }
    }
}*/