package com.example.helloworld

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.app.AlertDialog
//import android.view.MotionEvent
//import androidx.appcompat.app.AppCompatActivity
//import com.google.ar.core.Anchor
//import com.google.ar.core.HitResult
//import com.google.ar.core.Plane
//import com.google.ar.sceneform.AnchorNode
//import com.google.ar.sceneform.rendering.ModelRenderable
//import com.google.ar.sceneform.ux.ArFragment
//import com.google.ar.sceneform.ux.TransformableNode
//import java.util.function.Consumer
//import java.util.function.Function



//class HomeFragment : AppCompatActivity() {
class HomeFragment : Fragment() {
//    private var arCam: ArFragment? = null
//    private var clickNo = 0
//
//    private fun addModel(anchor: Anchor, modelRenderable: ModelRenderable) {
//
//        // Creating a AnchorNode with a specific anchor
//        val anchorNode = AnchorNode(anchor)
//
//        // attaching the anchorNode with the ArFragment
//        anchorNode.setParent(arCam!!.arSceneView.scene)
//        val transform = TransformableNode(arCam!!.transformationSystem)
//
//        // attaching the anchorNode with the TransformableNode
//        transform.setParent(anchorNode)
//
//        // attaching the 3d model with the TransformableNode that is
//        // already attached with the node
//        transform.renderable = modelRenderable
//        transform.select()
//    }

    override fun onCreateView(
//    fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//    ) {
    // Inflate the layout for this fragment
//        arCam = fragmentManager.findFragmentById(R.id.arCameraArea) as ArFragment
//        arCam!!.setOnTapArPlaneListener { hitResult: HitResult, plane: Plane?, motionEvent: MotionEvent? ->
//            clickNo++
//            if (clickNo == 1) {
//                val anchor = hitResult.createAnchor()
//                ModelRenderable.builder()
//                    .setSource(this, R.raw.syringe_aot)
//                    .setIsFilamentGltf(true)
//                    .build()
//                    .thenAccept(Consumer<ModelRenderable> { modelRenderable: ModelRenderable? -> addModel(anchor, modelRenderable!!) })
//                    .exceptionally(Function<Throwable, Void?> { throwable: Throwable ->
//                        val builder = AlertDialog.Builder(this)
//                        builder.setMessage("Somthing is not right" + throwable.message).show()
//                        null
//                    })
//            }
//        }
            return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply { }
            }
    }
}