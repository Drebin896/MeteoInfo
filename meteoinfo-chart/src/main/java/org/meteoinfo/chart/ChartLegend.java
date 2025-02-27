/* Copyright 2012 Yaqiang Wang,
 * yaqiang.wang@gmail.com
 * 
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or (at
 * your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser
 * General Public License for more details.
 */
package org.meteoinfo.chart;

import org.meteoinfo.common.DataConvert;
import org.meteoinfo.common.PointF;
import org.meteoinfo.common.XAlign;
import org.meteoinfo.common.YAlign;
import org.meteoinfo.geo.drawing.Draw;
import com.l2fprod.common.beans.BaseBeanInfo;
import com.l2fprod.common.beans.ExtendedPropertyDescriptor;
import com.l2fprod.common.beans.editor.ComboBoxPropertyEditor;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.List;
import org.meteoinfo.chart.plot.PlotOrientation;
import org.meteoinfo.geometry.legend.*;

/**
 *
 * @author Yaqiang Wang
 */
public class ChartLegend {
    // <editor-fold desc="Variables">

    //private final XY1DPlot plot;
    protected LegendScheme legendScheme;
    private LegendPosition position;
    protected float shrink;
    protected int aspect;
    private boolean colorBar;
    protected float x;
    protected float y;
    protected PlotOrientation orientation;
    protected Color background;
    protected boolean drawBackground;
    protected int width;
    protected int height;
    protected int legendWidth;
    protected int legendHeight;
    protected ChartText label;
    protected String labelLocation;
    protected Font tickLabelFont;
    protected Color tickLabelColor;
    protected float tickLabelAngle;
    protected boolean drawNeatLine;
    protected Color neatLineColor;
    protected float neatLineSize;
    private float breakSpace;
    private float topSpace;
    private float leftSpace;
    protected double _vBarWidth;
    protected double _hBarHeight;
    private int rowColNum = 1;
    private boolean autoRowColNum = true;
    private Dimension symbolDimension;
    protected boolean extendRect;
    protected boolean autoExtendFrac;
    protected float xshift;
    protected float yshift;
    // </editor-fold>
    // <editor-fold desc="Constructor">

    /**
     * Constructor
     *
     * @param ls LegendScheme
     */
    public ChartLegend(LegendScheme ls) {
        //this.plot = plot;
        this.legendScheme = ls;
        this.colorBar = false;
        this.position = LegendPosition.LOWER_CENTER_OUTSIDE;
        this.orientation = PlotOrientation.HORIZONTAL;
        this.shrink = 1.0f;
        this.aspect = 20;
        this.background = Color.white;
        this.drawBackground = false;
        drawNeatLine = true;
        neatLineColor = Color.black;
        neatLineSize = 1;
        breakSpace = 3;
        topSpace = 5;
        leftSpace = 5;
        _vBarWidth = 10;
        _hBarHeight = 10;
        this.labelLocation = "out";
        tickLabelFont = new Font("Arial", Font.PLAIN, 14);
        this.tickLabelColor = Color.black;
        this.tickLabelAngle = 0;
        this.symbolDimension = new Dimension(16, 10);
        this.extendRect = true;
        this.autoExtendFrac = false;
        this.xshift = 0;
        this.yshift = 0;
    }

    // </editor-fold>
    // <editor-fold desc="Events">
    // </editor-fold>
    // <editor-fold desc="Get Set Methods">
    /**
     * Get legend scheme
     *
     * @return Legend scheme
     */
    public LegendScheme getLegendScheme() {
        return this.legendScheme;
    }

    /**
     * Set legend scheme
     *
     * @param value Legend scheme
     */
    public void setLegendScheme(LegendScheme value) {
        this.legendScheme = value;
    }

    /**
     * Get if is color bar
     *
     * @return Boolean
     */
    public boolean isColorbar() {
        return this.colorBar;
    }

    /**
     * Set if is color bar
     *
     * @param value Boolean
     */
    public void setColorbar(boolean value) {
        this.colorBar = value;
    }

    /**
     * Get legend position
     *
     * @return Legend position
     */
    public LegendPosition getPosition() {
        return this.position;
    }

    /**
     * Set legend position
     *
     * @param value Legend position
     */
    public void setPosition(LegendPosition value) {
        this.position = value;
    }

    /**
     * Get shrink
     *
     * @return Shrink
     */
    public float getShrink() {
        return this.shrink;
    }

    /**
     * Set shrink
     *
     * @param value Shrink
     */
    public void setShrink(float value) {
        this.shrink = value;
    }

    /**
     * Get aspect
     *
     * @return Aspect
     */
    public int getAspect() {
        return this.aspect;
    }

    /**
     * Set aspect
     *
     * @param value Aspect
     */
    public void setAspect(int value) {
        this.aspect = value;
    }

    /**
     * Get X
     *
     * @return X value
     */
    public float getX() {
        return this.x;
    }

    /**
     * Set X
     *
     * @param value X value
     */
    public void setX(float value) {
        x = value;
    }

    /**
     * Get Y
     *
     * @return Y value
     */
    public float getY() {
        return this.y;
    }

    /**
     * Set Y
     *
     * @param value Y value
     */
    public void setY(float value) {
        y = value;
    }

    /**
     * Get width
     *
     * @return Width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Set width
     *
     * @param value Width
     */
    public void setWidth(int value) {
        this.width = value;
    }

    /**
     * Get height
     *
     * @return Height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Set height
     *
     * @param value Height
     */
    public void setHeight(int value) {
        this.height = value;
    }

    /**
     * Get legend width
     *
     * @return Legend width
     */
    public int getLegendWidth() {
        return this.legendWidth;
    }

    /**
     * Set legend width
     *
     * @param value Legend width
     */
    public void setLegendWidth(int value) {
        this.legendWidth = value;
    }

    /**
     * Get legend height
     *
     * @return Legend height
     */
    public int getLegendHeight() {
        return this.legendHeight;
    }

    /**
     * Set legend height
     *
     * @param value Legend height
     */
    public void setLegendHeight(int value) {
        this.legendHeight = value;
    }

    /**
     * Get plot orientation
     *
     * @return Plot orientation
     */
    public PlotOrientation getPlotOrientation() {
        return this.orientation;
    }

    /**
     * Set plot orientation
     *
     * @param value Plot orientation
     */
    public void setPlotOrientation(PlotOrientation value) {
        this.orientation = value;
    }

    /**
     * Get background
     *
     * @return Background
     */
    public Color getBackground() {
        return this.background;
    }

    /**
     * Set background
     *
     * @param value Background
     */
    public void setBackground(Color value) {
        this.background = value;
    }

    /**
     * Get if draw background
     *
     * @return Boolean
     */
    public boolean isDrawBackground() {
        return this.drawBackground;
    }

    /**
     * Set if draw background
     *
     * @param value Boolean
     */
    public void setDrawBackground(boolean value) {
        this.drawBackground = value;
    }

    /**
     * Get if draw neat line
     *
     * @return If draw neat line
     */
    public boolean isDrawNeatLine() {
        return drawNeatLine;
    }

    /**
     * Set if draw neat line
     *
     * @param istrue If draw neat line
     */
    public void setDrawNeatLine(boolean istrue) {
        drawNeatLine = istrue;
    }

    /**
     * Get neat line color
     *
     * @return Neat line color
     */
    public Color getNeatLineColor() {
        return neatLineColor;
    }

    /**
     * Set neat line color
     *
     * @param color Neat line color
     */
    public void setNeatLineColor(Color color) {
        neatLineColor = color;
    }

    /**
     * Get neat line size
     *
     * @return Neat line size
     */
    public float getNeatLineSize() {
        return neatLineSize;
    }

    /**
     * Set neat line size
     *
     * @param size Neat line size
     */
    public void setNeatLineSize(float size) {
        neatLineSize = size;
    }
    
    /**
     * Get break space
     * @return Break space
     */
    public float getBreakSpace() {
        return this.breakSpace;
    }
    
    /**
     * Set break space
     * @param value Break space
     */
    public void setBreakSpace(float value) {
        this.breakSpace = value;
    }

    /**
     * Get label
     *
     * @return Label
     */
    public ChartText getLabel() {
        return this.label;
    }

    /**
     * Set label
     *
     * @param value Label
     */
    public void setLabel(ChartText value) {
        this.label = value;
    }

    /**
     * Get label font
     *
     * @return Label font
     */
    public Font getLabelFont() {
        return this.label.getFont();
    }

    /**
     * Set label font
     *
     * @param value Label font
     */
    public void setLabelFont(Font value) {
        this.label.setFont(value);
    }

    /**
     * Get label color
     *
     * @return Label color
     */
    public Color getLabelColor() {
        return this.label.getColor();
    }

    /**
     * Set label color
     *
     * @param value Label color
     */
    public void setLabelColor(Color value) {
        this.label.setColor(value);
    }

    /**
     * Get label location (in, out, top, bottom, left, right)
     *
     * @return Label location
     */
    public String getLabelLocation() {
        return this.labelLocation;
    }

    /**
     * Set label location
     *
     * @param value Label location
     */
    public void setLabelLocation(String value) {
        this.labelLocation = value;
    }

    /**
     * Get Tick label font
     *
     * @return The Tick label font
     */
    public Font getTickLabelFont() {
        return tickLabelFont;
    }

    /**
     * Set Tick label font
     *
     * @param font The Tick label font
     */
    public void setTickLabelFont(Font font) {
        tickLabelFont = font;
    }

    /**
     * Get tick label color
     *
     * @return Tick label color
     */
    public Color getTickLabelColor() {
        return this.tickLabelColor;
    }

    /**
     * Set tick label color
     *
     * @param value Tick label color
     */
    public void setTickLabelColor(Color value) {
        this.tickLabelColor = value;
    }

    /**
     * Get tick lable angle
     *
     * @return Tick label angle
     */
    public float getTickLabelAngle() {
        return this.tickLabelAngle;
    }

    /**
     * Set tick label angle
     *
     * @param value Tick label angle
     */
    public void setTickLabelAngle(float value) {
        this.tickLabelAngle = value;
    }

    /**
     * Get column number
     *
     * @return Column number
     */
    public int getColumnNumber() {
        return rowColNum;
    }

    /**
     * Set column number
     *
     * @param value Column number
     */
    public void setColumnNumber(int value) {
        rowColNum = value;
    }

    /**
     * Get if automatic set row/col number
     *
     * @return Boolean
     */
    public boolean isAutoRowColNum() {
        return this.autoRowColNum;
    }

    /**
     * Set if automatic set row/col number
     *
     * @param value Boolean
     */
    public void setAutoRowColNum(boolean value) {
        this.autoRowColNum = value;
    }

    /**
     * Get symbol dimension
     *
     * @return Symbol dimension
     */
    public Dimension getSymbolDimension() {
        return this.symbolDimension;
    }

    /**
     * Set symbol dimension
     *
     * @param value Symbol dimension
     */
    public void setSymbolDimension(Dimension value) {
        this.symbolDimension = value;
    }

    /**
     * Set symbol width
     *
     * @param value Width
     */
    public void setSymbolWidth(int value) {
        this.symbolDimension.width = value;
    }

    /**
     * Set symbol height
     *
     * @param value height
     */
    public void setSymbolHeight(int value) {
        this.symbolDimension.height = value;
    }

    /**
     * Set symbol scale
     *
     * @param value Symble scale
     */
    public void setSymbolScale(float value) {
        double w = this.symbolDimension.getWidth() * value;
        double h = this.symbolDimension.getHeight() * value;
        this.symbolDimension.setSize(w, h);
    }

    /**
     * Get if extend rectangle - or triangle
     *
     * @return Boolean
     */
    public boolean isExtendRect() {
        return this.extendRect;
    }

    /**
     * Set if extend rectangle - or triangle
     *
     * @param value Boolean
     */
    public void setExtendRect(boolean value) {
        this.extendRect = value;
    }

    /**
     * Get if auto set extend fraction - extend has save width and height Only
     * valid for colorbar
     *
     * @return Boolean
     */
    public boolean isAutoExtendFrac() {
        return this.autoExtendFrac;
    }

    /**
     * Set if auto set extend fraction - extend has save width and height Only
     * valid for colorbar
     *
     * @param value
     */
    public void setAutoExtendFrac(boolean value) {
        this.autoExtendFrac = value;
    }

    /**
     * Set tick labels
     *
     * @param value Tick labels
     */
    public void setTickCaptions(List<String> value) {
        for (int i = 0; i < this.legendScheme.getBreakNum(); i++) {
            if (i < value.size()) {
                this.legendScheme.getLegendBreaks().get(i).setCaption(value.get(i));
            } else {
                break;
            }
        }
    }

    /**
     * Get x shift - pixel unit
     *
     * @return X shift
     */
    public float getXShift() {
        return this.xshift;
    }

    /**
     * Set x shift
     *
     * @param value X shift
     */
    public void setXShift(float value) {
        this.xshift = value;
    }

    /**
     * Get y shift - pixel unit
     *
     * @return Y shift
     */
    public float getYShift() {
        return this.yshift;
    }

    /**
     * Set y shift
     *
     * @param value Y shift
     */
    public void setYShift(float value) {
        this.yshift = value;
    }

    // </editor-fold>
    // <editor-fold desc="Methods">
    /**
     * Draw legend
     *
     * @param g Graphics2D
     * @param point Start point
     */
    public void draw(Graphics2D g, PointF point) {

        AffineTransform oldMatrix = g.getTransform();
        g.translate(point.X + this.xshift, point.Y + this.yshift);

        //Draw background color
        if (this.drawBackground) {
            g.setColor(this.background);
            g.fill(new Rectangle.Float(0, 0, this.width, this.height));
        }

        //Draw legend
        g.setStroke(new BasicStroke(1));
        switch (this.orientation) {
            case HORIZONTAL:
                drawHorizontalLegend(g, legendScheme);
                break;
            case VERTICAL:
                this.drawVerticalLegend(g, legendScheme);
                break;
        }

        //Draw neatline
        if (drawNeatLine) {
            Rectangle.Float mapRect = new Rectangle.Float(0, 0, this.width, this.height);
            g.setColor(neatLineColor);
            g.setStroke(new BasicStroke(neatLineSize));
            g.draw(mapRect);
        }

        g.setTransform(oldMatrix);
    }

    private void drawVerticalLegend(Graphics2D g, LegendScheme aLS) {
        String caption;
        float breakHeight = this.getBreakHeight(g);
        float symbolHeight = this.symbolDimension.height;
        float symbolWidth = this.symbolDimension.width;
        float colWidth = symbolWidth + getMaxLabelWidth(g) + 10;

        //Set columns
        int[] rowNums = new int[rowColNum];
        int ave = aLS.getVisibleBreakNum() / rowColNum;
        if (ave * rowColNum < aLS.getBreakNum()) {
            ave += 1;
        }
        int num = 0;
        int i;
        for (i = 1; i < rowColNum; i++) {
            rowNums[i] = ave;
            num += ave;
        }
        rowNums[0] = aLS.getVisibleBreakNum() - num;

        //Draw title        
        float y0 = 0;
        if (this.label != null) {
            float x0 = (float) (this.width / 2.);
            y0 += this.breakSpace * 2;
            this.label.draw(g, x0, y0);
            y0 += this.label.getDimension(g).height + this.breakSpace * 2;
        }

        //Draw legend                        
        float x, y;
        i = 0;
        for (int col = 0; col < rowColNum; col++) {
            x = symbolWidth / 2 + leftSpace + col * colWidth;
            y = y0 + breakHeight / 2 + breakSpace * 2;
            for (int row = 0; row < rowNums[col]; row++) {
                if (!aLS.getLegendBreaks().get(i).isDrawShape()) {
                    continue;
                }

                //y += breakHeight + breakSpace;
                ColorBreak cb = aLS.getLegendBreaks().get(i);
                if (!cb.isDrawShape()) {
                    continue;
                }
                caption = aLS.getLegendBreaks().get(i).getCaption();
                if (cb instanceof PointBreak) {
                    PointBreak aPB = (PointBreak) cb.clone();
                    ((PointBreak) aPB).setSize(((PointBreak) cb).getSize() * (symbolHeight / 10.f));
                    Draw.drawPoint(new PointF(x, y), aPB, g);
                } else if (cb instanceof PolylineBreak) {
                    PolylineBreak aPLB = (PolylineBreak) cb;
                    Draw.drawPolylineSymbol_S(new PointF(x, y), symbolWidth, symbolHeight, aPLB, g);
                } else if (cb instanceof PolygonBreak) {
                    Draw.drawPolygonSymbol(new PointF(x, y), symbolWidth, symbolHeight, (PolygonBreak) cb, g);
                } else {
                    PolygonBreak pgb = new PolygonBreak();
                    pgb.setColor(cb.getColor());
                    pgb.setOutlineColor(Color.black);
                    Draw.drawPolygonSymbol(new PointF(x, y), symbolWidth, symbolHeight, pgb, g);
                }

                PointF sP = new PointF(0, 0);
                sP.X = x + symbolWidth / 2;
                sP.Y = y;
                g.setColor(this.tickLabelColor);
                g.setFont(this.tickLabelFont);
                Draw.drawString(g, sP.X + 5, sP.Y, caption, XAlign.LEFT, YAlign.CENTER, true);
                y += breakHeight + breakSpace;

                i += 1;
            }
        }
    }

    private void drawHorizontalLegend(Graphics2D g, LegendScheme aLS) {
        String caption;
        float breakHeight = this.getBreakHeight(g);
        float symbolHeight = this.symbolDimension.height;
        float symbolWidth = this.symbolDimension.width;

        //Set columns
        int[] colNums = new int[rowColNum];
        int ave = aLS.getVisibleBreakNum() / rowColNum;
        if (ave * rowColNum < aLS.getBreakNum()) {
            ave += 1;
        }
        int num = 0;
        int i;
        for (i = 0; i < rowColNum - 1; i++) {
            colNums[i] = ave;
            num += ave;
        }
        colNums[rowColNum - 1] = aLS.getVisibleBreakNum() - num;

        //Draw legend    
        float x, y;
        y = this.breakSpace + breakHeight / 2;
        i = 0;
        for (int row = 0; row < rowColNum; row++) {
            x = this.symbolDimension.width / 2 + 5;
            for (int col = 0; col < colNums[row]; col++) {
                if (i >= aLS.getBreakNum()) {
                    break;
                }

                ColorBreak cb = aLS.getLegendBreaks().get(i);
                if (!cb.isDrawShape()) {
                    continue;
                }
                caption = aLS.getLegendBreaks().get(i).getCaption();
                if (cb instanceof PointBreak) {
                    PointBreak aPB = (PointBreak) cb;
                    Draw.drawPoint(new PointF(x, y), aPB, g);
                } else if (cb instanceof PolylineBreak) {
                    PolylineBreak aPLB = (PolylineBreak) cb;
                    Draw.drawPolylineSymbol_S(new PointF(x, y), symbolWidth, symbolHeight, aPLB, g);
                } else if (cb instanceof PolygonBreak) {
                    Draw.drawPolygonSymbol(new PointF(x, y), symbolWidth, symbolHeight, (PolygonBreak) cb, g);
                }

                PointF sP = new PointF(0, 0);
                sP.X = x + symbolWidth / 2;
                sP.Y = y;
                g.setColor(this.tickLabelColor);
                g.setFont(this.tickLabelFont);
                Draw.drawString(g, sP.X + 5, sP.Y, caption, XAlign.LEFT, YAlign.CENTER, true);
                Dimension dim = Draw.getStringDimension(caption, g);
                x += this.symbolDimension.width + dim.width + 15;
                i += 1;
            }
            y += breakHeight + this.breakSpace * 2;
        }
    }

    private int getMaxLabelWidth(Graphics2D g) {
        String caption;
        Dimension aSF;
        int bNum = legendScheme.getBreakNum();
        int labWidth = 0;
        g.setFont(this.tickLabelFont);
        for (int i = 0; i < bNum; i++) {
            caption = legendScheme.getLegendBreaks().get(i).getCaption();
            boolean isValid = true;
            if (isValid) {
                aSF = Draw.getStringDimension(caption, this.tickLabelAngle, g);
                int labwidth = aSF.width;
                if (labWidth < labwidth) {
                    labWidth = labwidth;
                }
            }
        }

        return labWidth;
    }

    private int getBreakHeight(Graphics2D g) {
        g.setFont(tickLabelFont);
        Dimension dim = Draw.getStringDimension(this.legendScheme.getLegendBreak(0).getCaption(), g);
        return Math.max(dim.height, this.symbolDimension.height);
    }

    /**
     * Get legend dimension
     *
     * @param g Graphics2D
     * @param limitDim Limit dimension
     * @return Legend dimension
     */
    public Dimension getLegendDimension(Graphics2D g, Dimension limitDim) {
        if (legendScheme != null) {
            if (this.colorBar) {
                switch (this.orientation) {
                    case VERTICAL:
                        this.width = (int) (this.getTickWidth(g) + limitDim.height * this.shrink / this.aspect + 5);
                        if (this.label != null) {
                            g.setFont(this.label.getFont());
                            this.width += (int) Draw.getStringDimension(label.getText(), g).height + 5;
                        }
                        break;
                    default:
                        g.setFont(this.tickLabelFont);
                        this.height = (int) (Draw.getStringDimension("test", g).height + limitDim.width * this.shrink / this.aspect + 5);
                        if (this.label != null) {
                            g.setFont(this.label.getFont());
                            Dimension dim = Draw.getStringDimension(label.getText(), g);
                            switch (this.labelLocation) {
                                case "top":
                                case "right":
                                    this.width += dim.width + 10;
                                    break;
                                default:
                                    this.height += (int) Draw.getStringDimension(label.getText(), g).height + 5;
                                    break;
                            }
                        }
                }
            } else {
                int breakHeight = getBreakHeight(g);
                int titleHeight = 0;
                int titleWidth = 0;
                if (this.label != null) {
                    Dimension dim = this.label.getDimension(g);
                    titleHeight = dim.height + (int) (this.breakSpace * 4);
                    titleWidth = dim.width;
                }
                switch (this.orientation) {
                    case VERTICAL:
                        //Get column number
                        if (this.autoRowColNum) {
                            int tHeight = (int) (legendScheme.getBreakNum() * (breakHeight + breakSpace)
                                    + breakSpace * 2 + breakHeight / 2 + 5);
                            rowColNum = 1;
                            if (tHeight > limitDim.height * 10 / 8) {
                                rowColNum = tHeight / (limitDim.height * 10 / 8) + 1;
                                if (rowColNum == 1) {
                                    rowColNum = 2;
                                } else {
                                    int n = legendScheme.getBreakNum() / rowColNum;
                                    int m = legendScheme.getBreakNum() % rowColNum;
                                    if (m != 0) {
                                        if (m <= n) {
                                            rowColNum += 1;
                                        } else {
                                            rowColNum += 2;
                                        }
                                    } else if (rowColNum * (limitDim.width * 8 / 10) < tHeight) {
                                        rowColNum += 1;
                                    }
                                }
                            }
                        }

                        //Get width
                        int colWidth = this.symbolDimension.width + getMaxLabelWidth(g) + 15;
                        this.width = colWidth * rowColNum;

                        //Get height
                        int[] rowNums = new int[rowColNum];
                        int ave = legendScheme.getBreakNum() / rowColNum;
                        if (ave * rowColNum < legendScheme.getBreakNum()) {
                            ave += 1;
                        }
                        int num = 0;
                        int i;
                        for (i = 0; i < rowColNum - 1; i++) {
                            rowNums[i] = ave;
                            num += ave;
                        }
                        rowNums[rowColNum - 1] = legendScheme.getBreakNum() - num;

//                        this.height = (int) (rowNums[0] * (breakHeight + _breakSpace)
//                                + _breakSpace * 2 + breakHeight / 2 + 5);
                        this.height = (int) (rowNums[0] * (breakHeight + breakSpace)
                                + breakSpace * 3);
                        break;
                    case HORIZONTAL:
                        //Get row number
                        if (this.autoRowColNum) {
                            int breakWidth = this.symbolDimension.width + this.getMaxLabelWidth(g) + 15;
                            int tWidth = breakWidth * legendScheme.getBreakNum();
                            rowColNum = 1;
                            if (tWidth > limitDim.width * 8 / 10) {
                                rowColNum = tWidth / (limitDim.width * 8 / 10);
                                if (rowColNum == 1) {
                                    rowColNum = 2;
                                } else {
                                    int n = legendScheme.getBreakNum() / rowColNum;
                                    int m = legendScheme.getBreakNum() % rowColNum;
                                    if (m != 0) {
                                        if (m <= n) {
                                            rowColNum += 1;
                                        } else {
                                            rowColNum += 2;
                                        }
                                    } else if (rowColNum * (limitDim.width * 8 / 10) < tWidth) {
                                        rowColNum += 1;
                                    }
                                }
                            }
                        }

                        //Get height
                        this.height = (int) (breakHeight + this.breakSpace * 2) * this.rowColNum;

                        //Get width
                        //FontMetrics metrics = g.getFontMetrics(tickFont);
                        ave = legendScheme.getBreakNum() / rowColNum;
                        if (ave * rowColNum < legendScheme.getBreakNum()) {
                            ave += 1;
                        }
                        num = 0;
                        int maxWidth = 0;
                        int tempWidth = 0;
                        for (i = 0; i < legendScheme.getBreakNum(); i++) {
                            if (num < ave) {
                                //tempWidth += this.symbolDimension.width + 15
                                //        + metrics.stringWidth(legendScheme.getLegendBreaks().get(i).getCaption());
                                tempWidth += this.symbolDimension.width + 15
                                        + Draw.getStringDimension(legendScheme.getLegendBreaks().get(i).getCaption(), g).width;
                                num += 1;
                            } else {
                                if (maxWidth < tempWidth) {
                                    maxWidth = tempWidth;
                                }
                                //tempWidth = metrics.stringWidth(legendScheme.getLegendBreaks().get(i).getCaption()) + 15;
                                tempWidth = Draw.getStringDimension(legendScheme.getLegendBreaks().get(i).getCaption(), g).width;
                                num = 1;
                            }
                        }
                        if (maxWidth < tempWidth) {
                            maxWidth = tempWidth;
                        }
                        if (maxWidth > limitDim.width) {
                            maxWidth = limitDim.width * 8 / 10;
                        }
                        this.width = maxWidth;
                        break;
                }
                this.height += titleHeight;
                this.width = Math.max(this.width, titleWidth);
            }
        }

        return new Dimension(this.width, this.height);
    }

    protected int getTickWidth(Graphics2D g) {
        float rwidth = 0;
        String caption = "";
        int bNum = this.legendScheme.getBreakNum();
        //FontMetrics metrics = g.getFontMetrics(this.tickFont);
        g.setFont(this.tickLabelFont);
        if (this.legendScheme.getLegendBreaks().get(bNum - 1).isNoData()) {
            bNum -= 1;
        }
        for (int i = 0; i < bNum; i++) {
            switch (this.legendScheme.getShapeType()) {
                case POINT:
                    PointBreak aPB = (PointBreak) legendScheme.getLegendBreaks().get(i);
                    if (legendScheme.getLegendType() == LegendType.GRADUATED_COLOR) {
                        caption = DataConvert.removeTailingZeros(aPB.getEndValue().toString());
                    } else {
                        caption = aPB.getCaption();
                    }
                    break;
                case POLYLINE:
                    PolylineBreak aPLB = (PolylineBreak) legendScheme.getLegendBreaks().get(i);
                    if (legendScheme.getLegendType() == LegendType.GRADUATED_COLOR) {
                        caption = DataConvert.removeTailingZeros(aPLB.getEndValue().toString());
                    } else {
                        caption = aPLB.getCaption();
                    }
                    break;
                case POLYGON:
                    PolygonBreak aPGB = (PolygonBreak) legendScheme.getLegendBreaks().get(i);
                    if (legendScheme.getLegendType() == LegendType.GRADUATED_COLOR) {
                        caption = DataConvert.removeTailingZeros(aPGB.getEndValue().toString());
                    } else {
                        caption = aPGB.getCaption();
                    }
                    break;
                case IMAGE:
                    ColorBreak aCB = legendScheme.getLegendBreaks().get(i);
                    if (legendScheme.getLegendType() == LegendType.GRADUATED_COLOR) {
                        caption = DataConvert.removeTailingZeros(aCB.getEndValue().toString());
                    } else {
                        caption = aCB.getCaption();
                    }
                    break;
            }

            boolean isValid = true;
            switch (legendScheme.getLegendType()) {
                case GRADUATED_COLOR:
                    if (i == bNum - 1) {
                        isValid = false;
                    }
                    break;
            }
            if (isValid) {
                //float labwidth = metrics.stringWidth(caption);
                float labwidth = (float) Draw.getStringDimension(caption, this.tickLabelAngle, g).getWidth();
                if (rwidth < labwidth) {
                    rwidth = labwidth;
                }
            }
        }

        return (int) rwidth;
    }

    protected int getTickHeight(Graphics2D g) {
        float rheight = 0;
        String caption = "";
        int bNum = this.legendScheme.getBreakNum();
        //FontMetrics metrics = g.getFontMetrics(this.tickFont);
        g.setFont(this.tickLabelFont);
        if (this.legendScheme.getLegendBreaks().get(bNum - 1).isNoData()) {
            bNum -= 1;
        }
        for (int i = 0; i < bNum; i++) {
            switch (this.legendScheme.getShapeType()) {
                case POINT:
                    PointBreak aPB = (PointBreak) legendScheme.getLegendBreaks().get(i);
                    if (legendScheme.getLegendType() == LegendType.GRADUATED_COLOR) {
                        caption = DataConvert.removeTailingZeros(aPB.getEndValue().toString());
                    } else {
                        caption = aPB.getCaption();
                    }
                    break;
                case POLYLINE:
                    PolylineBreak aPLB = (PolylineBreak) legendScheme.getLegendBreaks().get(i);
                    if (legendScheme.getLegendType() == LegendType.GRADUATED_COLOR) {
                        caption = DataConvert.removeTailingZeros(aPLB.getEndValue().toString());
                    } else {
                        caption = aPLB.getCaption();
                    }
                    break;
                case POLYGON:
                    PolygonBreak aPGB = (PolygonBreak) legendScheme.getLegendBreaks().get(i);
                    if (legendScheme.getLegendType() == LegendType.GRADUATED_COLOR) {
                        caption = DataConvert.removeTailingZeros(aPGB.getEndValue().toString());
                    } else {
                        caption = aPGB.getCaption();
                    }
                    break;
                case IMAGE:
                    ColorBreak aCB = legendScheme.getLegendBreaks().get(i);
                    if (legendScheme.getLegendType() == LegendType.GRADUATED_COLOR) {
                        caption = DataConvert.removeTailingZeros(aCB.getEndValue().toString());
                    } else {
                        caption = aCB.getCaption();
                    }
                    break;
            }

            boolean isValid = true;
            switch (legendScheme.getLegendType()) {
                case GRADUATED_COLOR:
                    if (i == bNum - 1) {
                        isValid = false;
                    }
                    break;
            }
            if (isValid) {
                float labheight = (float) Draw.getStringDimension(caption, 90 - Math.abs(this.tickLabelAngle), g).getWidth();
                if (rheight < labheight) {
                    rheight = labheight;
                }
            }
        }

        return (int) rheight;
    }

    /**
     * Update tick gap
     *
     * @param g Graphics2D
     * @return Ticks gap
     */
    protected int getTickGap(Graphics2D g) {
        if (this.tickLabelAngle != 0) {
            return 1;
        }

        double len;
        int n = this.legendScheme.getBreakNum();
        int nn;
        if (this.orientation == PlotOrientation.HORIZONTAL) {
            len = this.width;
            int labLen = this.getTickWidth(g);
            nn = (int) ((len * 0.8) / labLen);
        } else {
            len = this.height;
            FontMetrics metrics = g.getFontMetrics(tickLabelFont);
            nn = (int) (len / metrics.getHeight());
        }
        if (nn == 0) {
            nn = 1;
        }
        return n / nn + 1;
    }

    // </editor-fold>      
    // <editor-fold desc="BeanInfo">
    public class LayoutLegendBean {

        LayoutLegendBean() {
        }

        // <editor-fold desc="Get Set Methods">        
        /**
         * Get if draw neat line
         *
         * @return If draw neat line
         */
        public boolean isDrawNeatLine() {
            return drawNeatLine;
        }

        /**
         * Set if draw neat line
         *
         * @param istrue If draw neat line
         */
        public void setDrawNeatLine(boolean istrue) {
            drawNeatLine = istrue;
        }

        /**
         * Get neat line color
         *
         * @return Neat line color
         */
        public Color getNeatLineColor() {
            return neatLineColor;
        }

        /**
         * Set neat line color
         *
         * @param color Neat line color
         */
        public void setNeatLineColor(Color color) {
            neatLineColor = color;
        }

        /**
         * Get neat line size
         *
         * @return Neat line size
         */
        public float getNeatLineSize() {
            return neatLineSize;
        }

        /**
         * Set neat line size
         *
         * @param size Neat line size
         */
        public void setNeatLineSize(float size) {
            neatLineSize = size;
        }

        /**
         * Get tick label font
         *
         * @return The tick label font
         */
        public Font getTickLabelFont() {
            return tickLabelFont;
        }

        /**
         * Set tick label font
         *
         * @param font The tick label font
         */
        public void setTickLabelFont(Font font) {
            tickLabelFont = font;
        }

        /**
         * Get column number
         *
         * @return Column number
         */
        public int getColumnNumber() {
            return rowColNum;
        }

        /**
         * Set column number
         *
         * @param value Column number
         */
        public void setColumnNumber(int value) {
            rowColNum = value;
        }

        /**
         * Get is draw background
         *
         * @return Boolean
         */
        public boolean isDrawBackground() {
            return drawBackground;
        }

        /**
         * Set is draw background
         *
         * @param value Boolean
         */
        public void setDrawBackground(boolean value) {
            drawBackground = value;
        }

        /**
         * Get background color
         *
         * @return Background color
         */
        public Color getBackground() {
            return background;
        }

        /**
         * Set background color
         *
         * @param c Background color
         */
        public void setBackground(Color c) {
            background = c;
        }

        // </editor-fold>
    }

    public static class LayoutLegendBeanBeanInfo extends BaseBeanInfo {

        public LayoutLegendBeanBeanInfo() {
            super(LayoutLegendBean.class);
            ExtendedPropertyDescriptor e = addProperty("plotOrientation");
            e.setCategory("General").setDisplayName("Plot orientation");
            e.setPropertyEditorClass(PlotOrientationEditor.class);
            addProperty("tickFont").setCategory("General").setDisplayName("Tick Font");
            addProperty("drawBackground").setCategory("General").setDisplayName("Draw Background");
            addProperty("background").setCategory("General").setDisplayName("Background");
            addProperty("columnNumber").setCategory("General").setDisplayName("Column Number");
            addProperty("drawNeatLine").setCategory("Neat Line").setDisplayName("Draw Neat Line");
            addProperty("neatLineColor").setCategory("Neat Line").setDisplayName("Neat Line Color");
            addProperty("neatLineSize").setCategory("Neat Line").setDisplayName("Neat Line Size");
        }
    }

    public static class PlotOrientationEditor extends ComboBoxPropertyEditor {

        public PlotOrientationEditor() {
            super();
            PlotOrientation[] orientations = PlotOrientation.values();
            String[] types = new String[orientations.length];
            int i = 0;
            for (PlotOrientation type : orientations) {
                types[i] = type.toString();
                i += 1;
            }
            setAvailableValues(types);
        }
    }

    // </editor-fold>
}
