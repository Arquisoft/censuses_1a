//Press F1 (help) for detailed info about the architecture DSL.

//Simple Model/View/Controller example.

//Create an artifact with a name
artifact Model
{
    //Specify an include pattern
    include "**/com/application/**/model/**"
}

artifact View
{
    include "**/com/application/**/view/**"
    //Specify the allowed dependencies
    connect to Model
}

artifact Controller
{
    include "**/com/application/**/controller/**"
    connect to Model, View
}
