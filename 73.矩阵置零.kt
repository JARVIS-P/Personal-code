/**
 * 73.矩阵置零
 *
 * 解出问题之后要再想想还有没有优化空间(关于空间复杂度的优化可以尝试用已有的集合进行数据的存储)
 */
fun setZeroes(matrix: Array<IntArray>): Unit {//使用两个标记变量，分别记录第一行和第一列书否出现0，然后再用第一行和第一列来充当标记数组的作用
    val m= matrix.size
    val n= matrix[0].size

    var x=false
    var y=false

    for(i in 0 until m){
        if(matrix[i][0]==0){
            y=true
        }
    }

    for(i in 0 until n){
        if(matrix[0][i]==0){
            x=true
        }
    }

    for(i in 1 until m){
        for(j in 1 until n){
            if(matrix[i][j]==0){
                matrix[0][j]=0
                matrix[i][0]=0
            }
        }
    }

    for(i in 1 until m){
        for(j in 1 until n){
            if(matrix[i][0]==0||matrix[0][j]==0){
                matrix[i][j]=0
            }
        }
    }

    if(x){
        for(i in 0 until n){
            matrix[0][i]=0
        }
    }

    if(y){
        for(i in 0 until m){
            matrix[i][0]=0
        }
    }
}

fun setZeroes01(matrix: Array<IntArray>): Unit {//使用标记数组，分别记录行和列上需要置零的位数
    val m= matrix.size
    val n= matrix[0].size

    val x= arrayListOf<Int>()
    val y= arrayListOf<Int>()

    for(i in 0 until m){
        for(j in 0 until n){
            if(matrix[i][j]==0){
                if(i !in y){
                    y.add(i)
                }
                if(j !in x){
                    x.add(j)
                }
            }
        }
    }

    for(i in 0 until m){
        for(j in 0 until n){
            if(i in y){
                matrix[i][j]=0
            }
            if(j in x){
                matrix[i][j]=0
            }
        }
    }
}