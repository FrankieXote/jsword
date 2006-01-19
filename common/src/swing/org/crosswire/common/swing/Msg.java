/**
 * Distribution License:
 * JSword is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License, version 2.1 as published by
 * the Free Software Foundation. This program is distributed in the hope
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * The License is available on the internet at:
 *       http://www.gnu.org/copyleft/lgpl.html
 * or by writing to:
 *      Free Software Foundation, Inc.
 *      59 Temple Place - Suite 330
 *      Boston, MA 02111-1307, USA
 *
 * Copyright: 2005
 *     The copyright to this program is held by it's authors.
 *
 * ID: $Id$
 */
package org.crosswire.common.swing;

import org.crosswire.common.util.MsgBase;

/**
 * Compile safe Msg resource settings.
 * 
 * @see gnu.lgpl.License for license details.
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
final class Msg extends MsgBase
{
    static final Msg ERROR_READING = new Msg("BeanPanel.ErrorReading"); //$NON-NLS-1$
    // I18N: migrate this to an ActionFactory
    static final Msg CLOSE = new Msg("EirPanel.Close"); //$NON-NLS-1$
    static final Msg ERROR_OCCURED = new Msg("ExceptionPane.ErrorOccurred"); //$NON-NLS-1$
    // I18N: migrate this to an ActionFactory
    static final Msg OK = new Msg("ExceptionPane.OK"); //$NON-NLS-1$
    static final Msg DETAILS = new Msg("ExceptionPane.Details"); //$NON-NLS-1$
    static final Msg NO_FILE = new Msg("ExceptionPane.NoFile"); //$NON-NLS-1$
    static final Msg ERROR = new Msg("ExceptionPane.Error"); //$NON-NLS-1$
    static final Msg CAUSED_BY = new Msg("ExceptionPane.CausedBy"); //$NON-NLS-1$
    static final Msg NO_DESC = new Msg("ExceptionPane.NoDesc"); //$NON-NLS-1$
    static final Msg SOURCE_NOT_FOUND = new Msg("ExceptionPane.SourceNotFound"); //$NON-NLS-1$
    static final Msg SOURCE_FOUND = new Msg("ExceptionPane.SourceFound"); //$NON-NLS-1$
    static final Msg SOURCE_ATTEMPT = new Msg("ExceptionPane.SourceAttempt"); //$NON-NLS-1$
    static final Msg NO_PROBLEMS = new Msg("ExceptionShelf.NoProblems"); //$NON-NLS-1$
    static final Msg STATUS = new Msg("ExceptionShelf.Status"); //$NON-NLS-1$
    // I18N: migrate this to an ActionFactory
    static final Msg REMOVE = new Msg("ExceptionShelf.Remove"); //$NON-NLS-1$
    // I18N: migrate this to an ActionFactory
    static final Msg CANCEL = new Msg("FontChooser.Cancel"); //$NON-NLS-1$
    static final Msg SELECT_FONT = new Msg("FontChooser.SelectFont"); //$NON-NLS-1$
    static final Msg BOLD = new Msg("FontChooser.Bold"); //$NON-NLS-1$
    static final Msg ITALIC = new Msg("FontChooser.Italic"); //$NON-NLS-1$
    static final Msg PLAF_CHANGE = new Msg("LookAndFeelUtil.PlafChange"); //$NON-NLS-1$
    static final Msg KEYS = new Msg("MapTableModel.Keys"); //$NON-NLS-1$
    static final Msg VALUES = new Msg("MapTableModel.Values"); //$NON-NLS-1$

    /**
     * Passthrough ctor
     */
    private Msg(String name)
    {
        super(name);
    }
}