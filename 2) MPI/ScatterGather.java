 import mpi.MPI;

    public class ScatterGather {
   	 public static void main(String args[]){
   	 
   	 
   	 MPI.Init(args);                                                //Initialize MPI execution environment
	
   	 int rank = MPI.COMM_WORLD.Rank();				//Get the id of the process
	
   	 int size = MPI.COMM_WORLD.Size();				//total number of processes is stored in size
   	 int root=0;
	
   	 int sendbuf[]=null;						//array which will be filled with data by root process

   	 sendbuf= new int[size];

	//creates data to be scattered
	//current rank is 0
	
	
   	 if(rank==root){
   		 sendbuf[0] = 10;
   		 sendbuf[1] = 20;
   		 sendbuf[2] = 30;
   		 sendbuf[3] = 40;

		
   		 System.out.print("Processor "+rank+" has data: ");			//print current process number
   		 for(int i = 0; i < size; i++){
   			 System.out.print(sendbuf[i]+" ");
   		 }
   		 System.out.println();
   	 }
	
   	 int recvbuf[] = new int[1];							//collect data in recvbuf
	
	//scatter will distribute the tasks
   	 MPI.COMM_WORLD.Scatter(sendbuf, 0, 1, MPI.INT, recvbuf, 0, 1, MPI.INT, root);
   	 System.out.println("Processor "+rank+" has data: "+recvbuf[0]);
   	 System.out.println("Processor "+rank+" is doubling the data");
   	 recvbuf[0]=recvbuf[0]*2;


	//gather will receive and print output using for loop
   	 MPI.COMM_WORLD.Gather(recvbuf, 0, 1, MPI.INT, sendbuf, 0, 1, MPI.INT, root);
	
   	 if(rank==root){
   		System.out.println("Process 0 has data: ");
   		 for(int i=0;i<4;i++){
   			 System.out.print(sendbuf[i]+ " ");
   		 }
   	 }
	//Terminate MPI execution environment 
   	 MPI.Finalize();
    }
}

