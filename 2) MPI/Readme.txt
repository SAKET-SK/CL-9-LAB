MPI IMPLEMENTATION

1. Set MPJ_HOME environment variables:
export MPJ_HOME= --path to mpj directory --
2. Write your MPJ Express program (ScatterGather.java) and save it.
3. Compile : javac -cp $MPJ_HOME/lib/mpj.jar ScatterGather.java
4. Execute : $MPJ_HOME/bin/mpjrun.sh -np 4 ScatterGather