define(["jquery","handlebars","jquery-migrate","ud.package.default","ud.assessment","ud.wysiwyg"],function(e,t){e.widget("ud.ud_assessments_fill_in_the_blanks",e.ud.ud_assessment,{options:{instructorMode:!1,studentMode:!1,type:"fill-in-the-blanks",typeReadable:"Fill in the Blanks"},_create:function(){e.ud.ud_assessment.prototype._create.apply(this);if(this.options.studentMode||this.options.editMode){var t=this.options.prompt;this.question=t.question,this.answers=t.answers,this.answerElements={}}else if(this.options.instructorMode){var t=this.options.prompt;this.question=t.question,this.answers=t.answers,this.answerElements={}}this._initHandlebarsTemplates()},_initHandlebarsTemplates:function(){t.registerPartial("assessmentActionButtonTemplate",e("#assessmentActionButtonTemplate").html()),this.assessmentFillInTheBlanksTemplate=t.compile(e("#assessmentFillInTheBlanksTemplate").html()),this.assessmentFillInTheBlanksEditorTemplate=t.compile(e("#assessmentFillInTheBlanksEditorTemplate").html()),this.assessmentFillInTheBlanksUserResponseResultTemplate=t.compile(e("#assessmentFillInTheBlanksUserResponseResultTemplate").html())},_init:function(){},__rendered:!1,_render:function(){if(this.__rendered)return;this.parseQuestionForLoad(),this.element.html(this.assessmentFillInTheBlanksTemplate({question:this.question,isLastAssessment:this.isLastAssessment,response:this.response,studentMode:this.options.studentMode})),this.submitAnswerBtn=e(".submit-answer-btn",this.element),this.nextBtn=e(".next-btn",this.element),this.finalizeBtn=e(".finalize-btn",this.element),this.questionText=e(".question-text",this.element),this.applyUserResponse(),this.registerListeners(),this.__rendered=!0},_renderEditor:function(t){typeof t!="undefined"?(this.element.html(this.assessmentFillInTheBlanksEditorTemplate(t)),this.form=e("form",this.element),this.element.ud_initialize({onComplete:function(){this.applyInstructorCorrectResponse(),this.form.submit(this.editorFormOnSubmit.context(this))}.context(this)})):(this.element.html(this.assessmentFillInTheBlanksEditorTemplate({})),this.form=e("form",this.element),this.element.ud_initialize({onComplete:function(){this.form.submit(this.editorFormOnSubmit.context(this))}.context(this)}))},editorFormOnSubmit:function(t){t&&t.preventDefault();var n=this.form.serializeObject();n=this.parseQuestionForSave(n);if(e.isEmptyObject(n.question))return!1;if(e.isEmptyObject(n.correctResponse))return!1;n.correctResponse=JSON.stringify(n.correctResponse),this.options.editMode?(n.assessmentId=this.assessmentId,e(this).trigger("assessmentedited",[n,this.assessmentEditedHandler.context(this)])):e(this).trigger("assessmentcreated",[n,this.assessmentCreatedHandler.context(this)])},assessmentCreatedHandler:function(e){this.element.remove()},assessmentEditedHandler:function(e){},getUserResponse:function(){var t=[];return e("input[type=text]",this.questionText).each(function(n,r){var i=e(r).val();t.push(e.trim(i))}),t},applyUserResponse:function(){if(this.options.instructorMode)return;if(typeof this.response===undefined||this.response===null)return!1;for(var t in this.response){var n=e("input[data-order="+t+"]",this.questionText);n.after(e(this.assessmentFillInTheBlanksUserResponseResultTemplate({order:t})));var r=e.trim(this.response[t].replace(/\s{2,}/g," ")).toLowerCase(),i=e.trim(this.correctResponse[t].replace(/\s{2,}/g," ")).toLowerCase();r===i?e(".correct-answer[data-order="+t+"]",this.questionText).text(r).removeClass("none"):(e(".wrong-answer[data-order="+t+"]",this.questionText).text(r?r:"X").removeClass("none"),e(".correct-answer[data-order="+t+"]",this.questionText).text(i).removeClass("none")),n.addClass("none")}return!0},applyInstructorCorrectResponse:function(){var t=e("textarea",this.element);this.question=this.parseQuestionForEditOrPreview(this.question,this.correctResponse),t.data("ud-ud_wysiwyg").setValue(this.question)},registerListeners:function(){if(this.options.instructorMode){this.nextBtn.on("click",this.assessmentDoneHandler.context(this)),e(".view-results-btn",this.element).on("click",this.assessmentDoneHandler.context(this));return}this.nextBtn.on("click",this.assessmentDoneHandler.context(this)),this.finalizeBtn.on("click",this.assessmentDoneHandler.context(this));if(this.response)return;this.submitAnswerBtn.on("click",this.submitAnswerHandler.context(this))},deregisterListeners:function(){this.submitAnswerBtn.off("click")},answerResultsHandler:function(t,n){this.correctResponse=n;var r=this.applyUserResponse();r&&(this.deregisterListeners(),e(this.submitAnswerBtn).remove(),this.isLastAssessment?e(this.finalizeBtn).removeClass("none"):e(this.nextBtn).removeClass("none"))},parseQuestionForLoad:function(){this.question=this.question.replace(/<u-blank/g,'<input type="text"').replace(/<\/u-blank>/g,"")},parseQuestionForEditOrPreview:function(e,t){for(var n in t){var r=t[n],i='<u-blank data-order="'+n+'"></u-blank>',s="__"+r+"__",o="/</u-blank>/";e=e.replace(i,s).replace(o,"")}return e},replaceBlanksWithUBlanks:function(e,t,n){return t.replace(e,'<u-blank data-order="'+n+'"></u-blank>')},searchBlanksInString:function(e){var t=/__[^]+?__/gm;return e.match(t)},removeUnderscoresFromString:function(e){return e.replace(/__/g,"")},parseQuestionForSave:function(t){var n=e.trim(t.question),r=[],i=this.searchBlanksInString(n);for(var s in i)r.push(e.trim(this.removeUnderscoresFromString(i[s]))),n=this.replaceBlanksWithUBlanks(i[s],n,s);return t.question=n,t.correctResponse=r,t},submitAnswerHandler:function(t){t&&t.preventDefault(),t&&t.stopPropagation(),this.response=this.getUserResponse(),e(this).trigger("answer",[this.response,this.answerResultsHandler.context(this)])},assessmentDoneHandler:function(t){t&&t.preventDefault(),t&&t.stopPropagation(),e(this).trigger("assessmentdone")}})});