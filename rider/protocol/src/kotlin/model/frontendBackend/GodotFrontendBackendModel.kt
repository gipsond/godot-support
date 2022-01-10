package model.frontendBackendGodot

import com.jetbrains.rider.model.nova.ide.SolutionModel
import com.jetbrains.rd.generator.nova.*
import com.jetbrains.rd.generator.nova.PredefinedType.*
import com.jetbrains.rd.generator.nova.csharp.CSharp50Generator
import com.jetbrains.rd.generator.nova.kotlin.Kotlin11Generator

@Suppress("unused")
object GodotFrontendBackendModel : Ext(SolutionModel.Solution) {

    val GameOutputEvent = structdef("GameOutputEvent"){
        field("type", enum("GameOutputEventType") {
            +"Error"
            +"Message"
        })
        field("message", string)
    }

    init {
        setting(Kotlin11Generator.Namespace, "com.jetbrains.rider.model.godot.frontendBackend")
        setting(CSharp50Generator.Namespace, "JetBrains.Rider.Model.Godot.FrontendBackend")

        // Actions called from the backend to the frontend
        sink("activateRider", void).documentation = "Tell Rider to bring itself to the foreground. Called when opening a file from Godot"
        callback("startDebuggerServer", void, int).documentation = "Tell the frontend to start listening for debugger. Returns port. Used for debugging unit tests"
        sink("onGameOutputEvent", GameOutputEvent).documentation = "Pass output of the game under tests to frontend"

        // Misc backend/fronted context
        property("godotPath", string).documentation = "Path to GodotEditor"

        // Settings stored in the backend
        field("backendSettings", aggregatedef("GodotBackendSettings") {
            property("enableDebuggerExtensions", bool)
        })
    }
}
