
from ctypes import *



libc = cdll.LoadLibrary("/usr/lib/librsync.so.1") 
print libc

#
# Helper types
#

class FILEType(Structure):
    """stdio.h FILE type"""
    pass

FILE_p = POINTER(FILEType)
PyFile_AsFile =pythonapi.PyFile_AsFile
PyFile_AsFile.restype = FILE_p
PyFile_AsFile.argtypes = [py_object]



source = open("log.file","r")
sig = open("sig","w")
sourceP =PyFile_AsFile(source)
sigP = PyFile_AsFile(sig)
print "generate sig"
libc.rs_sig_file( sourceP, sigP,2048,8, None)
print "generate sig...done"


sig.close()
source.close()

newfile = open("log.file.new","r")
sig = open("sig","r")
delta = open("delta","w")

newfileP = PyFile_AsFile(newfile)
sigP = PyFile_AsFile(sig)
deltaP = PyFile_AsFile(delta)

print "generate delta"
libc.rs_delta_file(sigP, newfileP, deltaP, None)
print "generate delta...done"

newfile.close()
sig.close()
delta.close()

