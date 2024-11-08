package hwsein.developer.example.taskapplication.MVP.Presenter

import hwsein.developer.example.taskapplication.DataBase.TaskEntity
import hwsein.developer.example.taskapplication.MVP.Model.ModelHomeFragment
import hwsein.developer.example.taskapplication.MVP.View.ViewHomeFragment
import hwsein.developer.example.taskapplication.ext.BaseLifeCycle
import hwsein.developer.example.taskapplication.ext.Utils

class PresenterHomeFragment(
    private val view: ViewHomeFragment,
    private val model: ModelHomeFragment
) : BaseLifeCycle {

   override fun onCreate() {

        showDialogBox()
       initRecycler()
       getTaskState()

    }

    override fun onDestroy() {

        closeDb()

    }




    private fun showDialogBox() {

        view.addTask(
            object : Utils{

                override fun insertTask(data: TaskEntity){

                    model.insertUser(data)

                }

            }

            ,model.getDate())

    }

    private fun initRecycler(){

        view.initRecycler(
            arrayListOf() ,
            object  : Utils{

                override fun updateTask(task: TaskEntity) {
                    model.editTask(task)
                }

                override fun deleteTask(task: TaskEntity) {

                    model.deleteTask(task)

                }


            }
        )

    }

    private fun getTaskState(){

        view.getTaskByState(
            object : Utils{

                override fun requestData(state: Boolean) {
                    model.getTaskInDataBase(
                        state ,
                        object : Utils{

                            override fun getTask(tasks: List<TaskEntity>) {
                                view.showTask(tasks)
                            }

                        }
                    )
                }

            }
        )


    }

    private fun closeDb(){

        model.closeDataBase()

    }


}