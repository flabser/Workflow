<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template name="balanceholder-bin">
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/balance_holder/@caption"/>
            </div>
            <div class="controls">
                <xsl:choose>
                    <xsl:when test="@docid eq '' or @docid eq 'null'">
                        <select name="balanceholder" class="span8">
                            <xsl:apply-templates select="fields/balanceholder" mode="selected_options"/>
                        </select>
                    </xsl:when>
                    <xsl:otherwise>
                        <div class="input-placeholder span8">
                            <xsl:value-of select="fields/balanceholder"/>
                            <input type="hidden" name="balanceholder" value="{fields/balanceholder/@id}"
                                   disabled="disabled"/>
                        </div>
                    </xsl:otherwise>
                </xsl:choose>
            </div>
        </div>
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/bin/@caption"/>
            </div>
            <div class="controls">
                <input type="text" name="balanceholderbin" value="{fields/balanceholderbin}" class="span4"
                       disabled="disabled"/>
            </div>
        </div>
    </xsl:template>


    <xsl:template name="property_status_type">
        <!-- property_status -->
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/property_status/@caption"/>
            </div>
            <div class="controls">
                <xsl:apply-templates select="//constants[@entity = 'propertystatustype']/entry[@attrval != 'UNKNOWN']"
                                     mode="constants">
                    <xsl:with-param name="select" select="fields/propertystatus"/>
                    <xsl:with-param name="type" select="'radio'"/>
                </xsl:apply-templates>
            </div>
        </div>
    </xsl:template>

    <xsl:template name="signer">
        <!-- Подписывающий  -->
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/signer/@caption"/>
            </div>
            <div class="controls span7">
                <div>
                    <span class="input  disabled js-select">

                    </span>
                    <button type="button" class="btn btn select-button js-select-signer">
                        <span>+</span>
                    </button>
                </div>
            </div>
        </div>
    </xsl:template>

    <xsl:template name="recipient">
        <!-- Получатель  -->
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/recipient/@caption"/>
            </div>
            <div class="controls span7">
                <div>
                    <span class="input  disabled js-select">

                    </span>
                    <button type="button" class="btn btn select-button js-select-recipient">
                        <span>+</span>
                    </button>
                </div>
            </div>
        </div>
    </xsl:template>

    <xsl:template name="regnumber">
        <!-- Регистрационный номер  -->
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/reg_number/@caption"/>
            </div>
            <div class="controls">
                <input type="text" name="type" value="{fields/regnumber}" class="span2"/>
            </div>
        </div>
    </xsl:template>

    <xsl:template name="regdate">
        <!-- Дата регистрации  -->
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/reg_date/@caption"/>
            </div>
            <div class="controls">
                <input type="date" name="type" value="{fields/regdate}" class="span2"/>
            </div>
        </div>
    </xsl:template>


    <xsl:template name="description">
        <!-- Описание -->
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/description/@caption"/>
            </div>
            <div class="controls">
                <textarea name="description" class="span8">
                    <xsl:value-of select="fields/description"/>
                </textarea>
            </div>
        </div>
    </xsl:template>

    <xsl:template name="tags">
        <!-- Метки -->
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/tags/@caption"/>
            </div>
            <div class="controls">
                <select name="tags" class="span8" multiple="true">
                    <xsl:apply-templates select="fields/tags" mode="selected_options"/>
                </select>
            </div>
        </div>
    </xsl:template>

    <xsl:template name="notes">
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/notes/@caption"/>
            </div>
            <div class="controls">
                <textarea name="notes" class="span8">
                    <xsl:value-of select="fields/notes"/>
                </textarea>
            </div>
        </div>
    </xsl:template>

    <xsl:template name="upload-files">
        <xsl:param name="input-name"/>

        <div class="form-group">
            <button type="button" class="btn btn-upload" data-upload="{$input-name}">
                <i class="fa fa-paperclip"></i>
                <span>
                    <xsl:value-of select="//captions/attach_file/@caption"/>
                </span>
            </button>
            <div class="attachments" data-upload-files="{$input-name}">
                <xsl:for-each select="fields/attachments/attachment">
                    <div class="attachments-file">
                        <a class="file-name" data-file="{filename}" href="{url}">
                            <xsl:value-of select="filename"/>
                        </a>
                        <span class="btn btn-sm btn-link btn-remove-file on-edit">
                            <i class="fa fa-times"></i>
                        </span>
                    </div>
                </xsl:for-each>
            </div>
        </div>
    </xsl:template>

    <xsl:template name="docinfo">
        <fieldset class="fieldset">
            <div class="form-group">
                <div class="control-label">
                    <xsl:value-of select="//captions/editable/@caption"/>
                </div>
                <div class="controls">
                    <span class="input-placeholder">
                        <i>
                            <xsl:attribute name="class">
                                <xsl:choose>
                                    <xsl:when test="@editable = 'true'">
                                        fa fa-pencil
                                    </xsl:when>
                                    <xsl:when test="@editable = 'false'">
                                        fa fa-eye
                                    </xsl:when>
                                    <xsl:otherwise>
                                        fa fa-warning
                                    </xsl:otherwise>
                                </xsl:choose>
                            </xsl:attribute>
                        </i>
                    </span>
                </div>
            </div>
            <div class="form-group">
                <div class="control-label">
                    <xsl:value-of select="//captions/reg_date/@caption"/>
                </div>
                <div class="controls">
                    <span class="input-placeholder">
                        <xsl:value-of select="fields/regdate"/>
                    </span>
                </div>
            </div>
            <div class="form-group">
                <div class="control-label">
                    <xsl:value-of select="//captions/author/@caption"/>
                </div>
                <div class="controls">
                    <span class="input-placeholder">
                        <xsl:value-of select="fields/author"/>
                    </span>
                </div>
            </div>
        </fieldset>
    </xsl:template>

    <xsl:template name="documents-of-title">
        <!-- Правоустанавливающие документы -->
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/tech_cert/@caption"/>
            </div>
            <div class="controls">
                <input type="text" name="techcert" value="{fields/techcert}" class="span8"/>
            </div>
        </div>
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/reg_cert/@caption"/>
            </div>
            <div class="controls">
                <input type="text" name="regcert" value="{fields/regcert}" class="span8"/>
            </div>
        </div>
        <div class="form-group">
            <div class="control-label">
                <xsl:value-of select="//captions/decrees_acts/@caption"/>
            </div>
            <div class="controls">
                <textarea name="decreesacts" class="span8">
                    <xsl:value-of select="fields/decreesacts"/>
                </textarea>
            </div>
        </div>
    </xsl:template>



    <xsl:template match="*" mode="selected_options">
        <xsl:choose>
            <xsl:when test="entry">
                <xsl:for-each select="entry">
                    <option value="{@id}" selected="selected">
                        <xsl:value-of select="."/>
                    </option>
                </xsl:for-each>
            </xsl:when>
            <xsl:otherwise>
                <xsl:if test="@id">
                    <option value="{@id}" selected="selected">
                        <xsl:value-of select="."/>
                    </option>
                </xsl:if>
            </xsl:otherwise>
        </xsl:choose>
    </xsl:template>

    <xsl:template match="entry" mode="constants">
        <xsl:param name="select"/>
        <xsl:param name="type" select="'checkbox'"/>
        <xsl:param name="name" select="$select/name()"/>
        <xsl:variable name="attrval" select="@attrval"/>
        <xsl:variable name="lowerAttrval" select="lower-case(@attrval)"/>
        <xsl:variable name="caption" select="//captions/*[lower-case(name()) = $lowerAttrval]/@caption"/>

        <label class="input">
            <input type="{$type}" name="{$name}" value="{@attrval}">
                <xsl:if test="contains($attrval, $select)">
                    <xsl:attribute name="checked" select="checked"/>
                </xsl:if>
                <span>
                    <xsl:choose>
                        <xsl:when test="$caption != ''">
                            <xsl:value-of select="$caption"/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of select="."/>
                        </xsl:otherwise>
                    </xsl:choose>
                </span>
            </input>
        </label>
    </xsl:template>

</xsl:stylesheet>
