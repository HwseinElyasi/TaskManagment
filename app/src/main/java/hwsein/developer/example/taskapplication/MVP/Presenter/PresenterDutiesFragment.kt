package hwsein.developer.example.taskapplication.MVP.Presenter

import hwsein.developer.example.taskapplication.DataBase.TaskEntity
import hwsein.developer.example.taskapplication.MVP.Model.ModelHomeFragment
import hwsein.developer.example.taskapplication.MVP.View.ViewDutiesFragment
import hwsein.developer.example.taskapplication.ext.Utils

class PresenterDutiesFragment(
    private val view: ViewDutiesFragment,
    private val model: ModelHomeFragment
) {

    fun onCreate() {

        showDialogAndInsertDuties()
        initRecycler()
        initDuties()

    }

    private fun showDialogAndInsertDuties() {

        view.showDialog(
            object : Utils {

                override fun insertTask(data: TaskEntity) {

                    model.insertUser(data)

                }

            },
            model.getDate()
        )


    }

    private fun initRecycler(){

        view.initRecycler(
            arrayListOf() ,
            object : Utils{

                override fun deleteTask(task: TaskEntity) {

                    model.deleteTask(task)

                }

            }
        )


    }

    private fun initDuties(){

        model.getNullStateTaskInDataBase(
            object : Utils{

                override fun getNullStateTask(task: List<TaskEntity>) {

                    view.showDuties(task)

                }

            }
        )

        }


    }
