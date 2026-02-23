/*
We will mark your work as soon as possible when the demis start working, or when we
get the automatic marking software going, and give you immediate feedback. We are
still attempting to get the automatic marking software in place. When this works you
will get feedback in real time, despite always uploading completed work to iKamva today
before leaving the laboratory.
6. Overview The idea of today’s practical is to collect useful data for the running times of
two simple algorithms for looking up keys in order to access data in an array of records.
Each of these records is a Node, that consists of an integer key and its associated String
of data. These records are given to you in the file ulysses.numbered. Your code will
run two sets of lookups on this data stored in an array in your program. When doing
linear search one assumes that the keys are unsorted and when doing binary search
the algorithm needs a sorted set of keys. You need to determine the speed of the two
algorithms.
7. The keys lie in the range 00001–32654. Your code must compare only the lookup—
insertion and deletion need not be done—for each of the two kinds of lists. Note that
you need to have only one copy of the array in your code. The assumption that the
code is sorted for doing binary search must be made. The same data is used for doing
both the linear searching and binary searching. The idea is that the experiment must
convince you that binary searching does in fact work in logarithmic time and that linear
searching is a lot slower.
8. Theexperimentwilldoneas follows.Generate30keys intherightrangeandlookup
eachkey, gettingtheaveragetimingandstandarddeviationforeachof theseruns to
producemeaningfulstatistics.Tabulatetheaverageandstandarddeviationofthesetwo
times.
9. Thefinal result thatyour codegenerates is fournumbers, i.e., twoaveragesandtwo
standarddeviationsofeachofthetimings.
10. Thecodebelowmaybeusedasastartingtemplateforyourprogramming.
1 //Codeisstoredas13template.java
2 import java.lang.Math.∗; import java.io.∗; import java.text.∗;
3
4 publicclasstimeMethods{
5 publicstaticintN=....;
6 publicstaticvoidmain(Stringargs[]){
7
8 DecimalFormattwoD=newDecimalFormat(”0.00”);
9 DecimalFormatfourD=newDecimalFormat(”0.0000”);
10 DecimalFormatfiveD=newDecimalFormat(”0.00000”);
11
12 longstart,finish;
13 doublerunTime=0, runTime2=0, time;
14 doubletotalTime=0.0;
15 intn=N;
16 intrepetition, repetitions=30;
17
18 runTime=0;
19 for(repetition=0; repetition<repetitions; repetition++){
20 start=System.currentTimeMillis();
21
22 //call theprocedurestotimehere:
23 linearsearch(...);
24 binarysearch(...);
25 //Figureouthowtoalterthisguidelinehere,
26
27 finish=System.currentTimeMillis();
28
29 time=(double)(finish−start);
30 runTime+=time;
31 runTime2+=(time∗time);}
32
33 doubleaveRuntime=runTime/repetitions;
34 doublestdDeviation=
35 Math.sqrt(runTime2−repetitions∗aveRuntime∗aveRuntime)/(repetitions−1);
36
37 System.out.printf(”\n\n\fStatistics\n”);
38 System.out.println(”________________________________________________”);
39 System.out.println(”Total time = ”+runTime/1000+”s.”);
40 System.out.println(”Total time\u00b2 = ”+runTime2);
41 System.out.println(”Average time= ”+fiveD.format(aveRuntime/1000)
42 +”s. ”+’\u00B1’+” ”+fourD.format(stdDeviation)+”ms.”);
43 System.out.println(”Standarddeviation= ”+fourD.format(stdDeviation));
44 System.out.println(”n = ”+n);
45 System.out.println(”Average time / run= ”+fiveD.format(aveRuntime/n∗1000)
46 +’\u00B5’+”s. ”);
47
48 System.out.println(”Repetitions = ”+repetitions);
49 System.out.println(”________________________________________________”);
50 System.out.println();
51 System.out.println();}}
52
53 staticvoidoneofyourMethods(intn,
54 yourMethodParameter1,
55 yourMethodParameter2, . . .){
56 //Thedeclarationsandbodyofyourmethod/s
57 //Thefinal statementofthiscode.})
*/
