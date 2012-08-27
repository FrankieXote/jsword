package org.crosswire.jsword.book.sword.state;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URI;

import org.crosswire.common.util.FileUtil;
import org.crosswire.common.util.IOUtil;
import org.crosswire.common.util.Logger;
import org.crosswire.common.util.NetUtil;
import org.crosswire.common.util.Reporter;
import org.crosswire.jsword.JSOtherMsg;
import org.crosswire.jsword.book.BookException;
import org.crosswire.jsword.book.sword.SwordBookMetaData;
import org.crosswire.jsword.book.sword.SwordConstants;
import org.crosswire.jsword.book.sword.SwordUtil;

/**
 * Stores the random access files required for processing the passage request
 * 
 * The caller is required to close to correctly free resources and avoid File
 * pointer leaks
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith [dmsmith555 at yahoo dot com]
 */
public class RawFileBackendState extends RawBackendState {
    public static final String INCFILE = "incfile";
    /** The log stream */
    private static final Logger log = Logger.getLogger(RawFileBackendState.class);
    private File incfile;
    private Integer incfileValue;

    
    public RawFileBackendState(SwordBookMetaData bookMetaData) {
       super(bookMetaData);
    }
    
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.sword.AbstractBackend#isWritable()
     */
    public boolean isWritable() {
            File incFile = getIncfile();

            if (getOtTextFile().exists() && getOtTextFile().canRead() && getOtTextFile().canWrite() && getNtTextFile().exists()
                    && getNtTextFile().canRead() && getNtTextFile().canWrite() && getOtIdxFile().exists() && getOtIdxFile().canRead()
                    && getOtIdxFile().canWrite() && getNtIdxFile().exists() && getNtIdxFile().canRead() && getNtIdxFile().canWrite()
                    && incFile.exists() && incFile.canRead() && incFile.canWrite()) {
                return true;
            }
            return false;
    }
    
    private int readIncfile() throws IOException {
        int ret = -1;
        
        if(incfile == null) {
            //then attempt  to initialise it
            initIncFile();
        }
        
        if (this.incfile != null) {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(this.incfile);
                byte[] buffer = new byte[4];
                if (fis.read(buffer) != 4) {
                    log.error("Read data is not of appropriate size of 4 bytes!");
                    throw new IOException("Incfile is not 4 bytes long");
                }
                ret = SwordUtil.decodeLittleEndian32(buffer, 0);
                
                //also store this
                this.incfileValue = ret;
            } catch (FileNotFoundException e) {
                log.error("Error on writing to incfile, file should exist already!");
                log.error(e.getMessage());
            } finally {
                IOUtil.close(fis);
            }
        }

        return ret;
    }

    private void initIncFile() {
        try {
            File tempIncfile = new File(SwordUtil.getExpandedDataPath(getBookMetaData()).getPath() + File.separator + INCFILE);
            if (tempIncfile.exists()) {
                this.incfile = tempIncfile;
            }
        } catch (BookException e) {
            log.error("Error on checking incfile: " + e.getMessage());
            this.incfile = null;
        }
    }
    

    /**
     * @return the incfileValue
     */
    public int getIncfileValue() {
        if(incfileValue == null) {
            try {
                readIncfile();
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }
        
        return incfileValue;
    }

    public void setIncfileValue(int incValue) {
        this.incfileValue = incValue;
        
    }

    /**
     * @return the incfile
     */
    public File getIncfile() {
        if(incfile == null) {
            initIncFile();
        }
        return incfile;
    }

    /**
     * @param incfile the incfile to set
     */
    public void setIncfile(File incfile) {
        this.incfile = incfile;
    }


    
}
