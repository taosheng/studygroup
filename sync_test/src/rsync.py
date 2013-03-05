
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
print "done"
