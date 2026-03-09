
def System (command):
	#A function to run a system command and print it first.
	#A system command is a string, e.g. "ls -l" or "sort anagrams > anagrams.sorted"
	print ("-"*50+">", command)
	s = system(command)
	return s

def signature(word):
	return ''.join(sorted(word))
		

def main():
	
	if len(argv) == 2:
		inputfile = argv[1]
		f = open(inputfile, encoding="latin-1")
		print ("Data file: ", inputfile)
	else:
		print ("Usage: ./anagrams inputfile.\n You gave:\n %s" % argv[1])
		exit()
	
	D = {}
	
	linenumber = 0 
	line = f.readline()
	lines = 0
	while line != "":
	  linenumber += 1
	  words = line.split()
	  for w in words:
	    W = w.strip('[0123456789(,.,.;:_.!?---)]')
	    w = W[:]
	    if w in D:
	      D[w] += 1
	    else:
	      D[w] = 1
	  line = f.readline()
	  lines += 1
	
	f.close()
	
	A = {}
	
	for w in D:
		a = signature(w)
		if a not in A:
			A[a] = [w]
		else:
			A[a].append(w)
	while line != "":
		word = line[:-1]
		print ("<%s>" % word)
		tryanagram = signature(word)
		if tryanagram in A:
			print (word, A[tryanagram])
	
	f = open("anagrams", 'w')
	for key in A.keys():
		if len(A[key]) > 1:
			anagramlist = ""
			for word in A[key]:
				if anagramlist == "":
					anagramlist = word
				else:
					anagramlist += " " + word
			print (anagramlist, end = "\\\\\n", file = f)
			for repeat in range(len(A[key])-1):
				space = anagramlist.find(' ')
				anagramlist = anagramlist[space+1:] + ' ' + anagramlist[:space]
				print (anagramlist, end = "\\\\\n", file = f)
	f.close()
	
	s = System ("sort anagrams > anagrams.sorted")
	
	asf = open("anagrams.sorted", 'r')
	aa = asf.readlines()
	asf.close()
	
	asftex = open("latex/theAnagrams.tex", 'w')
	letter = 'X'
	for lemma in aa:
		initial = lemma[0]
		if initial.lower() != letter.lower():
			letter = initial
			print ("\n\\vspace{14pt}\n\\noindent\\textbf{\\Large %s}\\\\*[+12pt]" % initial.upper(), file = asftex)
		print ("%s" % lemma, file = asftex, end = "")
	
	asftex.close() 
	
	s = System ("rm anagrams anagrams.sorted")
	
if __name__ == "__main__":
	main()
