Yes — this is much easier to memorize if **everything starts from the left** and the relationships flow to the right.

```text id="io5r8x"
JAVA CLASSIC I/O RELATIONSHIPS
==============================


BYTE INPUT
==========

InputStream
    |
    +--> FileInputStream
    |        |
    |        +--> reads BYTES
    |
    +--> FilterInputStream
             |
             +--> DataInputStream
                      |
                      +--> implements DataInput
                               |
                               +--> readInt()
                               +--> readLong()
                               +--> readDouble()
                               +--> readUTF()


BYTE OUTPUT
===========

OutputStream
    |
    +--> FileOutputStream
    |        |
    |        +--> writes BYTES
    |
    +--> FilterOutputStream
             |
             +--> DataOutputStream
                      |
                      +--> implements DataOutput
                               |
                               +--> writeInt()
                               +--> writeLong()
                               +--> writeDouble()
                               +--> writeUTF()


CHARACTER INPUT
===============

Reader
    |
    +--> InputStreamReader
    |        |
    |        +--> converts BYTES → CHARACTERS
    |
    +--> BufferedReader
             |
             +--> read()
             +--> ready()


CHARACTER OUTPUT
================

Writer
    |
    +--> FileWriter
    |
    +--> OutputStreamWriter
    |        |
    |        +--> converts CHARACTERS → BYTES
    |
    +--> BufferedWriter
             |
             +--> write()
             +--> newLine()


RANDOM ACCESS
=============

RandomAccessFile
    |
    +--> implements DataInput
    |        |
    |        +--> readInt()
    |        +--> readLong()
    |        +--> readDouble()
    |        +--> readUTF()
    |
    +--> implements DataOutput
             |
             +--> writeInt()
             +--> writeLong()
             +--> writeDouble()
             +--> writeUTF()


============================================================
MOST IMPORTANT RELATIONSHIPS
============================================================


InputStream
    |
    +--> FileInputStream


InputStream
    |
    +--> FilterInputStream
             |
             +--> DataInputStream
                      |
                      +--> implements DataInput


OutputStream
    |
    +--> FileOutputStream


OutputStream
    |
    +--> FilterOutputStream
             |
             +--> DataOutputStream
                      |
                      +--> implements DataOutput


Reader
    |
    +--> InputStreamReader


Reader
    |
    +--> BufferedReader


Writer
    |
    +--> FileWriter


Writer
    |
    +--> OutputStreamWriter


Writer
    |
    +--> BufferedWriter


RandomAccessFile
    |
    +--> implements DataInput
    |
    +--> implements DataOutput


============================================================
KEY EXAM POINT
============================================================

RandomAccessFile DOES NOT extend DataInputStream.

RandomAccessFile DOES NOT extend DataOutputStream.

Instead:

RandomAccessFile
    |
    +--> implements DataInput
    |
    +--> implements DataOutput


DataInputStream
    |
    +--> implements DataInput


DataOutputStream
    |
    +--> implements DataOutput


Therefore:

DataInput
    ^
    |
    +---- DataInputStream
    |
    +---- RandomAccessFile


DataOutput
    ^
    |
    +---- DataOutputStream
    |
    +---- RandomAccessFile


============================================================
EXTENDS vs IMPLEMENTS
============================================================

FileInputStream
    |
    +--> extends InputStream


DataInputStream
    |
    +--> extends FilterInputStream
    |
    +--> implements DataInput


DataOutputStream
    |
    +--> extends FilterOutputStream
    |
    +--> implements DataOutput


RandomAccessFile
    |
    +--> implements DataInput
    |
    +--> implements DataOutput
```

### The mental map I'd use for the exam

```text
InputStream  → bytes in
OutputStream → bytes out

Reader       → characters in
Writer       → characters out

DataInput    → read primitive values
DataOutput   → write primitive values

RandomAccessFile
    → read primitives
    → write primitives
    → random positioning
```

And the **two most important arrows** are:

```text
DataInput  ← DataInputStream
DataInput  ← RandomAccessFile

DataOutput ← DataOutputStream
DataOutput ← RandomAccessFile
```

Those are **interface relationships**, not inheritance relationships.
