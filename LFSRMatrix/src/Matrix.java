
public class Matrix {

	static int N = 128;
	long[][] matrice =
	{
	    	{0,1,0,0}, 
	    	{0,0,1,0},
	    	{1,0,0,1},
	    	{1,0,0,0}
	    	
	};
	
	long[][] initMat = new long[128][128];
	
	public long[][] getMatrice() {
		return matrice;
	}

	public void setMatrice(long[][] matrice) {
		this.matrice = matrice;
	}

	long [][] matriceC0 = new long [1][128];

	public long[][] getMatriceC0() {
		return matriceC0;
	}

	public void setMatriceC0(long[][] matriceC0) {
		this.matriceC0 = matriceC0;
	}

	
	Matrix(){
		
		int k = 1;//My Matrix M
		for(int i = 0; i < 127; i ++ ) {
			for(int j = 1 ; j < 128 ; j++) {
				if(k == j) {
					this.initMat[i][j] = 1;
				}
				else
					this.initMat[i][j] = 0;
			}
			k++;
		}
		
		for(int i = 0 ; i < 128; i++) {
			if(i == 127 || i == 126 || i == 80 || i == 33) {//Change here
				this.initMat[i][0] = 1;
			}else {
				this.initMat[i][0] = 0;
			}
		}
		
		for(int j = 1 ; j < 128 ; j++) {
			this.initMat[127][j] = 0;
		}
		
		for(int j = 0 ; j < 128 ; j++) {
			this.matriceC0[0][j] = 1;
		}
		//FAIRE CO aussi
		
	}
	
	public long[][] getInitMat() {
		return initMat;
	}

	/*public void setMatrice3(long[][] matrice3) {
		this.initMat = matrice3;
	}*/

	protected void displayMatrix() {
		for(int i = 0 ; i < 2 ; i++) {
			for (int j = 0 ; j < 2 ;j++ ) {
				System.out.print(""+ matrice[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	
	
	protected long[][] multiplicar(long[][] A , long[][] B) {
		/*int[][] A = this.matrice;
		int[][] B = this.matrice;*/
        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        long[][] C = new long[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0;
            }
        }

        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
            	//C[i][j] = 0;
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += (A[i][k] * B[k][j]);
                }
                C[i][j] = (C[i][j]) % 2;
            }
        }

        return C;
    }
	
	
	
	
	protected long[][] matrixPower(long counter , long [][] A) {
		/*int[][] A = this.matrice;
		int[][] B = this.matrice;*/
		
		if (counter == 1) {
			return A;
		}
		
        int aRows = A.length;
        int aColumns = A[0].length;
        
        long[][] B = matrixPower(counter - 1, A);
        
        int bRows = B.length;
        int bColumns = B[0].length;

        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        long[][] C = new long[aRows][bColumns];
        /*for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0;
            }
        }*/
        
        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
            	C[i][j] = 0;
                for (int k = 0; k < aColumns; k++) { // aColumn
                	
                    C[i][j] += (A[i][k] * B[k][j])%2;
                    //System.out.println("-> "+ A[i][k] * B[k][j]);
                }
                //C[i][j] = (C[i][j]) % 2;
            }
        }

        return C;
    }
	
	
	
	
	
	/**
	 * This code (Power Matrix) come from the internet: https://ideone.com/WiVoV0
	 * But I don't use this one it is just for test and a better runtime
	**/
	protected long[][] matrixPower(long [][] base, long pow)	{
		long [][] ans = new long [N][N];
		// generate identity matrix
		for (int i = 0; i < N; i++)	ans[i][i] = 1;
 
		// binary exponentiation
		while ( pow != 0 )	{
			if	( (pow&1) != 0 )	ans = multiplyMatrix(ans, base);
 
			base = multiplicar(base, base);
 
			pow >>= 1;
		}
 
		return	ans;
	}
 
	/**
	 * 
	 * 
	**/
	public long [][] multiplyMatrix(long [][] m, long [][] m2)	{
		long [][] ans = new long [N][N];
 
		for (int i = 0; i < N; i++)	for (int j = 0; j < N; j++)	{
			ans[i][j] = 0;
			for (int k = 0; k < N; k++)	{
				ans[i][j] += m[i][k] * m2[k][j];
			}
			ans[i][j] = ans[i][j]% 2 ;
		}
 
		return	ans;
	}
	
	
}
