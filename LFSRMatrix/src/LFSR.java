
public class LFSR {

	public static void main(String[] args) throws Exception {
		Matrix mat = new Matrix();
		
		//mat.displayMatrix();
		
		
		//M power 2^64 = 2^8 * 2^8 * 2^8 * 2^8 * 2^8 * 2^8 * 2^8 * 2^8
		long[][] result = mat.matrixPower(256, mat.getInitMat());
		result = mat.matrixPower(256, result);
		result = mat.matrixPower(256, result);
		result = mat.matrixPower(256, result);
		result = mat.matrixPower(256, result);
		result = mat.matrixPower(256, result);
		result = mat.matrixPower(256, result);
		result = mat.matrixPower(256, result);
		
		
		//M power 2^64 = 2^16 * 2^16 * 2^16 * 2^16
		/*long[][] result = mat.matrixPower(mat.getMatrice3(), 65536);
		result = mat.matrixPower(result, 65536);
		result = mat.matrixPower(result, 65536);
		result = mat.matrixPower(result, 65536);*/
		
		
		/*long[][] result = mat.getMatrice3(); So Long
		long[][] initMat = result;
		
		for(int i = 0 ; i < 65536 ; i++) {
			result = mat.multiplicar(result, initMat);
		}
		for(int i = 0 ; i < 65536 ; i++) {
			result = mat.multiplicar(result, initMat);
		}
		for(int i = 0 ; i < 65536 ; i++) {
			result = mat.multiplicar(result, initMat);
		}
		for(int i = 0 ; i < 65536 ; i++) {
			result = mat.multiplicar(result, initMat);
		}*/
		
		
		
		//(M power 250)
		long[][] result2 = mat.matrixPower(mat.getInitMat(),250);//Change here
		
		//(M power 2^64) * (M power 250)
		long[][] resultM = mat.multiplicar(result, result2);
		//long[][] result = mat.getMatrice3();
		
        
		//((M power 2^64) * (M power 250)) * CO
		long[][] resultF = mat.multiplicar(mat.getMatriceC0(), resultM);
        
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 128; j++)
                System.out.print((resultF[i][j] ) + "");
            //System.out.println();
        }
        
        
        
        
		
        //result = mat.multiplicar(result, mat.matrice2);*/
        
        /*System.out.println();
        
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < 128; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();
        }*/
        
	}

}
