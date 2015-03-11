define(["jquery","handlebars","jquery-migrate","ud.package.default","ud.assessment"],function(e,t){e.widget("ud.ud_assessments_true_false",e.ud.ud_assessment,{options:{instructorMode:!1,studentMode:!1,type:"true-false",typeReadable:"True False"},form:null,_create:function(){e.ud.ud_assessment.prototype._create.apply(this);if(this.options.studentMode||this.options.editMode){var t=this.options.prompt;this.question=t.question,this.answers=t.answers,this.answerElements={}}else if(this.options.instructorMode){var t=this.options.prompt;this.question=t.question,this.answers=t.answers,this.answerElements={}}this._initHandlebarsTemplates()},_initHandlebarsTemplates:function(){t.registerPartial("assessmentActionButtonTemplate",e("#assessmentActionButtonTemplate").html()),this.assessmentTrueFalseTemplate=t.compile(e("#assessmentTrueFalseTemplate").html()),this.assessmentTrueFalseEditorTemplate=t.compile(e("#assessmentTrueFalseEditorTemplate").html())},_init:function(){},__rendered:!1,_render:function(){if(this.__rendered)return;this.element.html(this.assessmentTrueFalseTemplate({question:this.question,answers:this.answers,isLastAssessment:this.isLastAssessment,response:this.response,studentMode:this.options.studentMode})),this.submitAnswerBtn=e(".submit-answer-btn",this.element),this.nextBtn=e(".next-btn",this.element),this.finalizeBtn=e(".finalize-btn",this.element),this.mapOptions(),this.applyUserResponse(),this.registerListeners(),this.__rendered=!0},_renderEditor:function(t){typeof t!="undefined"?(this.element.html(this.assessmentTrueFalseEditorTemplate(t)),this.form=e("form",this.element),this.element.ud_initialize({onComplete:function(){this.mapEditorOptions(),this.applyInstructorCorrectResponse(),this.form.submit(this.editorFormOnSubmit.context(this))}.context(this)})):(this.element.html(this.assessmentTrueFalseEditorTemplate({})),this.form=e("form",this.element),this.element.ud_initialize({onComplete:function(){this.form.submit(this.editorFormOnSubmit.context(this))}.context(this)}))},editorFormOnSubmit:function(t){t&&t.preventDefault();var n=this.form.serializeObject();typeof n.assessmentoption!="undefined"?(n.correctResponse=JSON.stringify([n.assessmentoption]),this.options.editMode?(n.assessmentId=this.assessmentId,e(this).trigger("assessmentedited",[n,this.assessmentEditedHandler.context(this)])):e(this).trigger("assessmentcreated",[n,this.assessmentCreatedHandler.context(this)])):window.alert("Please choose the correct answer.")},assessmentCreatedHandler:function(e){this.element.remove()},assessmentEditedHandler:function(e){},mapOptions:function(){e("ul.answers li",this.element).each(function(t,n){this.answerElements[e(n).data("option")]=n}.context(this))},mapEditorOptions:function(){this.trueFalseBtnsDiv=e("#true-false-btns",this.element),e("input[type=radio]",this.trueFalseBtnsDiv).each(function(t,n){var r=e(n).val();this.answerElements[r]=n}.context(this))},applyUserResponse:function(){if(this.options.instructorMode)return;if(this.response===undefined||this.response===null)return!1;var t=this.answerElements[this.response[0]],n=this.answerElements[this.correctResponse[0]];return e.each(this.answerElements,function(t,n){e(n).removeClass("selected")}),t==n?e(t).addClass("correct"):(e(t).addClass("wrong"),e(n).addClass("correct")),!0},applyInstructorCorrectResponse:function(){e.each(this.answerElements,function(t,n){e(n).removeAttr("checked")});var t=this.answerElements[this.correctResponse[0]];e(t).attr("checked","checked");var n=e("textarea",this.element);n.data("ud-ud_wysiwyg").setValue(this.question)},registerListeners:function(){if(this.options.instructorMode){this.nextBtn.on("click",this.assessmentDoneHandler.context(this)),e(".view-results-btn",this.element).on("click",this.assessmentDoneHandler.context(this));return}this.nextBtn.on("click",this.assessmentDoneHandler.context(this)),this.finalizeBtn.on("click",this.assessmentDoneHandler.context(this));if(this.response)return;e.each(this.answerElements,function(t,n){e(n).click(function(){this.answerClickHandler([t])}.context(this))}.context(this)),this.submitAnswerBtn.on("click",this.submitAnswerHandler.context(this))},deregisterListeners:function(){e.each(this.answerElements,function(t,n){e(n).unbind("click")}.context(this)),this.submitAnswerBtn.off("click")},answerClickHandler:function(t){this.responseToSubmit=t;var n=this.answerElements[this.responseToSubmit[0]];e.each(this.answerElements,function(t,n){e(n).removeClass("selected")}),e(n).addClass("selected")},answerResultsHandler:function(t,n){this.correctResponse=n;var r=this.applyUserResponse();r&&(this.deregisterListeners(),e(this.submitAnswerBtn).remove(),this.isLastAssessment?e(this.finalizeBtn).removeClass("none"):e(this.nextBtn).removeClass("none"))},submitAnswerHandler:function(t){t&&t.preventDefault(),t&&t.stopPropagation(),this.response=this.responseToSubmit,e(this).trigger("answer",[this.response,this.answerResultsHandler.context(this)])},assessmentDoneHandler:function(t){t&&t.preventDefault(),t&&t.stopPropagation(),e(this).trigger("assessmentdone")}})});